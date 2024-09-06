package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.ReqLectureVO;

public class ReqLectureDao {

	private DataSource dataSource = null;

	public ReqLectureDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public ArrayList<ReqLectureVO> list() {
		ArrayList<ReqLectureVO> ReqLectureList = new ArrayList<ReqLectureVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from ReqLecture order by memb_code";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int lecture_code 		= resultSet.getInt("lecture_code");
				int seq_no 				= resultSet.getInt("seq_no");
				int memb_code 			= resultSet.getInt("memb_code");
				Timestamp lect_req_dt 	= resultSet.getTimestamp("lect_req_dt");
				Timestamp lect_cncl_dt 	= resultSet.getTimestamp("lect_cncl_dt");
				Timestamp lect_exit_dt 	= resultSet.getTimestamp("lect_exit_dt");
				int lect_fee			= resultSet.getInt("lect_fee");
				int lect_repay_fee 		= resultSet.getInt("lect_repay_fee");

				ReqLectureVO ReqLecture = new ReqLectureVO(lecture_code, seq_no, memb_code, lect_req_dt, lect_cncl_dt, lect_exit_dt, lect_fee,lect_repay_fee);

				ReqLectureList.add(ReqLecture);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			  try {
		            if (resultSet != null)   resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connection != null)   connection.close();
		         } catch (Exception e2) {


			}
		}

		return ReqLectureList;

	}
	
	public ReqLectureVO getReqLecture(int ilecture_code,int iseq_no) {

		ReqLectureVO ReqLecture = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from ReqLecture where lecture_code = ? and seq_no = ?";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(ilecture_code));
			preparedStatement.setInt(2, Integer.valueOf(iseq_no));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				
				int lecture_code 		= resultSet.getInt("lecture_code");
				int seq_no 				= resultSet.getInt("seq_no");
				int memb_code 			= resultSet.getInt("memb_code");
				Timestamp lect_req_dt 	= resultSet.getTimestamp("lect_req_dt");
				Timestamp lect_cncl_dt 	= resultSet.getTimestamp("lect_cncl_dt");
				Timestamp lect_exit_dt 	= resultSet.getTimestamp("lect_exit_dt");
				int lect_fee 			= resultSet.getInt("lect_fee");
				int lect_repay_fee 		= resultSet.getInt("lect_repay_fee");

				ReqLecture = new ReqLectureVO(lecture_code, seq_no, memb_code, lect_req_dt, lect_cncl_dt, lect_exit_dt, lect_fee,lect_repay_fee);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			  try {
		            if (resultSet != null)   resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connection != null)   connection.close();
		         } catch (Exception e2) {


			}
		}

		return ReqLecture;

	}
	
	public int ReqLectureInsert(int lecture_code,int  memb_code,Timestamp lect_req_dt,Timestamp lect_cncl_dt,Timestamp lect_exit_dt,int lect_fee,int lect_repay_fee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "insert into ReqLecture (lecture_code,seq_no,memb_code,lect_req_dt,lect_cncl_dt,lect_exit_dt,lect_fee,lect_repay_fee)"
				+ " values (?,(select (nvl(max(seq_no),0)+1) from ReqLecture where lecture_code = ? ), ? , ?, ?, ?, ?, ? )";
		
		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, 		lecture_code);
			preparedStatement.setInt(2, 		lecture_code);	// max(seq_no)를 가져오기 위해 추가
			preparedStatement.setInt(3, 		memb_code);	
			preparedStatement.setTimestamp(4, 	lect_req_dt);
			preparedStatement.setTimestamp(5, 	lect_cncl_dt);
			preparedStatement.setTimestamp(6, 	lect_exit_dt);
			preparedStatement.setInt(7, 		lect_fee);
			preparedStatement.setInt(8, 		lect_repay_fee);
	        
	        //write update insert
	        rn  = preparedStatement.executeUpdate();    
	        System.out.println("입력건수 " + rn);
			if (rn != 1) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("확인");
		} finally {

			  try {
		            if (preparedStatement != null) preparedStatement.close();
		            if (connection != null)   connection.close();
		         } catch (Exception e2) {


			}
		}

		return rn;
	}
	
	public int ReqLectureModify(int lecture_code,int seq_no, int  memb_code,Timestamp lect_req_dt,Timestamp lect_cncl_dt,Timestamp lect_exit_dt,int lect_fee,int lect_repay_fee) {

		ReqLectureVO ReqLecture = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "update ReqLecture set memb_code = ?,lect_req_dt=?,lect_cncl_dt=?,lect_exit_dt=?,lect_fee=?,lect_repay_fee=? where lecture_code = ? and seq_no = ?";

		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, 		memb_code);
			preparedStatement.setTimestamp(2, 	lect_req_dt);
			preparedStatement.setTimestamp(3, 	lect_cncl_dt);
			preparedStatement.setTimestamp(4, 	lect_exit_dt);
			preparedStatement.setInt(5, 		lect_fee);
			preparedStatement.setInt(6, 		lect_repay_fee);
			preparedStatement.setInt(7, 		lecture_code);
			preparedStatement.setInt(8, 		seq_no);
			
			// delete update insert는 executeUpdate 로 처리
			rn = preparedStatement.executeUpdate();

			if (rn != 1) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			  try {
		            if (preparedStatement != null) preparedStatement.close();
		            if (connection != null)   connection.close();
		         } catch (Exception e2) {


			}
		}

		return rn;
	}
	
	
	
}
