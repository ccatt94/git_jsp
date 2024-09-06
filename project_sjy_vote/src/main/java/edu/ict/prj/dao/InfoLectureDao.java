package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.InfoLectureVO;

public class InfoLectureDao {

/*
강의코드	lecture_code	NUMBER(5)
강의명	lecture_name	VARCHAR2(100)
강사코드	ins_code	NUMBER(5)
모집시작일	mozip_st_dt	DATE
모집마감일	mozip_end_dt	DATE
강의시작일	lect_st_dt	DATE
강의종료일	lect_end_dt	DATE
수강료	lect_fee	NUMBER(12)
강의수준	lect_grade	NUMBER(1)
강의장소	lect_place	VARCHAR2(100)
 */
	private DataSource dataSource = null;

	public InfoLectureDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public ArrayList<InfoLectureVO> list(String v_confirm) {
		ArrayList<InfoLectureVO> InfoLectureList = new ArrayList<InfoLectureVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "";
		
		if (Integer.valueOf(v_confirm) == 1) {	// 모집중일때
			sql = "select rownum as seqno,a.lecture_code,a.lecture_name,a.ins_code,(select ins_name from infoinstructor where ins_code = a.ins_code) ins_name, " + 
		      " to_char(a.mozip_st_dt,'yyyy-mm-dd') mozip_st_dt, to_char(a.mozip_end_dt,'yyyy-mm-dd') mozip_end_dt,  " +
		      " to_char(a.lect_st_dt,'yyyy-mm-dd') lect_st_dt, to_char(a.lect_end_dt,'yyyy-mm-dd') lect_end_dt,  " +
		      " to_char(a.lect_fee,'L999,999,999') lect_fee,a.lect_grade,a.lect_place,(select count(memb_code) from reqlecture where lecture_code = a.lecture_code and  lect_cncl_dt is null) reqcnt  " +
		      " from InfoLecture a where (to_char(a.mozip_end_dt,'yyyy-mm-dd') >= to_char(sysdate,'yyyy-mm-dd'))  order by a.lecture_code ";
			System.out.println("KKKKKKKK sql1 [" + sql + "]");
		}	
		else if (Integer.valueOf(v_confirm) == 2) { // 모집이끝났을때
			sql = "select rownum as seqno,a.lecture_code,a.lecture_name,a.ins_code,(select ins_name from infoinstructor where ins_code = a.ins_code) ins_name, " + 
				      " to_char(a.mozip_st_dt,'yyyy-mm-dd') mozip_st_dt, to_char(a.mozip_end_dt,'yyyy-mm-dd') mozip_end_dt,  " +
				      " to_char(a.lect_st_dt,'yyyy-mm-dd') lect_st_dt, to_char(a.lect_end_dt,'yyyy-mm-dd') lect_end_dt,  " +
				      " to_char(a.lect_fee,'L999,999,999') lect_fee,a.lect_grade,a.lect_place,(select count(memb_code) from reqlecture where lecture_code = a.lecture_code and  lect_cncl_dt is null) reqcnt  " +
				      " from InfoLecture a where (to_char(a.mozip_end_dt,'yyyy-mm-dd') < to_char(sysdate,'yyyy-mm-dd'))  order by a.lecture_code ";
			System.out.println("KKKKKKKK sql2 [" + sql + "]");
	}	
		else {	
			sql = "select rownum as seqno,a.lecture_code,a.lecture_name,a.ins_code,(select ins_name from infoinstructor where ins_code = a.ins_code) ins_name, " + 
				      " to_char(a.mozip_st_dt,'yyyy-mm-dd') mozip_st_dt, to_char(a.mozip_end_dt,'yyyy-mm-dd') mozip_end_dt,  " +
				      " to_char(a.lect_st_dt,'yyyy-mm-dd') lect_st_dt, to_char(a.lect_end_dt,'yyyy-mm-dd') lect_end_dt,  " +
				      " to_char(a.lect_fee,'L999,999,999') lect_fee,a.lect_grade,a.lect_place,(select count(memb_code) from reqlecture where lecture_code = a.lecture_code and  lect_cncl_dt is null) reqcnt  " +
				      " from InfoLecture a order by a.lecture_code ";
			System.out.println("KKKKKKKK sql3 [" + sql + "]");
		}

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int seqno		 			= resultSet.getInt("seqno");
				int lecture_code 			= resultSet.getInt("lecture_code");
				String lecture_name 		= resultSet.getString("lecture_name");
				int ins_code 				= resultSet.getInt("ins_code");
				String ins_name 			= resultSet.getString("ins_name");
				String mozip_st_dt 			= resultSet.getString("mozip_st_dt");
				String mozip_end_dt 		= resultSet.getString("mozip_end_dt");
				String lect_st_dt 			= resultSet.getString("lect_st_dt");
				String lect_end_dt 			= resultSet.getString("lect_end_dt");
				String lect_fee 			= resultSet.getString("lect_fee");
				int lect_grade 				= resultSet.getInt("lect_grade");
				String lect_place 			= resultSet.getString("lect_place");
				int reqcnt 					= resultSet.getInt("reqcnt");
				
				InfoLectureVO InfoLecture = new InfoLectureVO(seqno,lecture_code, lecture_name, ins_code,ins_name, mozip_st_dt, mozip_end_dt, lect_st_dt, lect_end_dt,lect_fee,lect_grade,lect_place,reqcnt);

				InfoLectureList.add(InfoLecture);
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

		return InfoLectureList;

	}
	
	public InfoLectureVO getInfoLecture(int ilecture_code) {

		InfoLectureVO InfoLecture = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from InfoLecture where lecture_code = ?";

		sql = "select rownum as seqno,a.lecture_code,a.lecture_name,a.ins_code,(select ins_name from infoinstructor where ins_code = a.ins_code) ins_name, " + 
			      " to_char(a.mozip_st_dt,'yyyy-mm-dd') mozip_st_dt, to_char(a.mozip_end_dt,'yyyy-mm-dd') mozip_end_dt,  " +
			      " to_char(a.lect_st_dt,'yyyy-mm-dd') lect_st_dt, to_char(a.lect_end_dt,'yyyy-mm-dd') lect_end_dt,  " +
			      " to_char(a.lect_fee,'L999,999,999') lect_fee,a.lect_grade,a.lect_place,(select count(memb_code) from reqlecture where lecture_code = a.lecture_code and  lect_cncl_dt is null) reqcnt  " +
			      " from InfoLecture a where a.lecture_code = ? ";
		
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(ilecture_code));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int seqno 				= resultSet.getInt("seqno");
				int lecture_code 		= resultSet.getInt("lecture_code");
				String lecture_name 	= resultSet.getString("lecture_name");
				int ins_code 			= resultSet.getInt("ins_code");
				String ins_name 		= resultSet.getString("ins_name");
				String mozip_st_dt 		= resultSet.getString("mozip_st_dt");
				String mozip_end_dt 	= resultSet.getString("mozip_end_dt");
				String lect_st_dt 		= resultSet.getString("lect_st_dt");
				String lect_end_dt 		= resultSet.getString("lect_end_dt");
				String lect_fee 			= resultSet.getString("lect_fee");
				int lect_grade 			= resultSet.getInt("lect_grade");
				String lect_place 		= resultSet.getString("lect_place");
				int reqcnt 				= resultSet.getInt("reqcnt");

				InfoLecture = new InfoLectureVO(seqno,lecture_code, lecture_name, ins_code,ins_name, mozip_st_dt, mozip_end_dt, lect_st_dt, lect_end_dt,lect_fee,lect_grade,lect_place,reqcnt);
				
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

		return InfoLecture;

	}
	
	public int InfoLectureInsert(int lecture_code,String  lecture_name,int ins_code,Timestamp mozip_st_dt,Timestamp mozip_end_dt,Timestamp lect_st_dt,Timestamp lect_end_dt,int lect_fee,int lect_grade,String lect_place ) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "insert into InfoLecture (lecture_code, lecture_name, ins_code, mozip_st_dt,mozip_end_dt, lect_st_dt, lect_end_dt,lect_fee,lect_grade,lect_place)"
				+ " values ((select (nvl(max(lecture_code),0)+1) from InfoLecture), ? , ?, ?, ?, ?, ?, ?, ?, ? )";
		
		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, 		lecture_name);
			preparedStatement.setInt(2, 		ins_code);
			preparedStatement.setTimestamp(3, 	mozip_st_dt);
			preparedStatement.setTimestamp(4, 	mozip_end_dt);
			preparedStatement.setTimestamp(5, 	lect_st_dt);
			preparedStatement.setTimestamp(6, 	lect_end_dt);
			preparedStatement.setInt(7, 		lect_fee);
			preparedStatement.setInt(8, 		lect_grade);
			preparedStatement.setString(9, 		lect_place);
	        
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
	
	public int InfoLectureModify(int lecture_code,String  lecture_name,int ins_code,Timestamp mozip_st_dt,Timestamp mozip_end_dt,Timestamp lect_st_dt,Timestamp lect_end_dt,int lect_fee,int lect_grade,String lect_place) {

		InfoLectureVO InfoLecture = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "update InfoLecture set lecture_name = ?,ins_code=?,mozip_st_dt=?,mozip_end_dt=?,lect_st_dt=?,lect_end_dt=?,lect_fee=?,lect_grade=?,lect_place=? where lecture_code = ?";

		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, 		lecture_name);
			preparedStatement.setInt(2, 		ins_code);
			preparedStatement.setTimestamp(3, 	mozip_st_dt);
			preparedStatement.setTimestamp(4, 	mozip_end_dt);
			preparedStatement.setTimestamp(5, 	lect_st_dt);
			preparedStatement.setTimestamp(6, 	lect_end_dt);
			preparedStatement.setInt(7, 		lect_fee);
			preparedStatement.setInt(8, 		lect_grade);
			preparedStatement.setString(9, 		lect_place);
			preparedStatement.setInt(10, 		lecture_code);
			
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
