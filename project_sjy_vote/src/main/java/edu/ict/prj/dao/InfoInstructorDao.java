package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.InfoInstructorVO;


public class InfoInstructorDao {

	private DataSource dataSource = null;

	public InfoInstructorDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<InfoInstructorVO> list(String v_confirm) {
		ArrayList<InfoInstructorVO> InfoInstructorList = new ArrayList<InfoInstructorVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "";
		
		if (Integer.valueOf(v_confirm) == 1) {	// 재직중일때
			sql = "select rownum as seqno,a.ins_code,a.ins_name,to_char(a.empl_DATE,'yyyy-mm-dd') empl_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
		      " to_char(a.qual_date,'yyyy-mm-dd') qual_date,a.sex_g,a.tel_no,(select count(lecture_code) from Infolecture  where ins_code = a.ins_code) as lect_cnt  "
		      + " from InfoInstructor a where a.retire_date is null order by a.ins_code ";
			System.out.println("KKKKKKKK sql1 [" + sql + "]");
		}	
		else if (Integer.valueOf(v_confirm) == 2) { // 퇴직했을때
			sql = "select rownum as seqno,a.ins_code,a.ins_name,to_char(a.empl_DATE,'yyyy-mm-dd') empl_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
			      " to_char(a.qual_date,'yyyy-mm-dd') qual_date,a.sex_g,a.tel_no,(select count(lecture_code) from Infolecture  where ins_code = a.ins_code) as lect_cnt  "
		      + "from InfoInstructor a where a.retire_date is not null order by a.ins_code ";
			System.out.println("KKKKKKKK sql2 [" + sql + "]");
		}	
		else if (Integer.valueOf(v_confirm) == 3) { // 전체 	
			sql = "select rownum as seqno,a.ins_code,a.ins_name,to_char(a.empl_DATE,'yyyy-mm-dd') empl_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
				      " to_char(a.qual_date,'yyyy-mm-dd') qual_date,a.sex_g,a.tel_no,(select count(lecture_code) from Infolecture  where ins_code = a.ins_code) as lect_cnt  "
		     + "from InfoInstructor a order by a.ins_code";
			System.out.println("KKKKKKKK sql3 [" + sql + "]");
		}else if (Integer.valueOf(v_confirm) == 4){  // 강사등록후 조회시 - 강사번호 역순으로 조회
			sql = "select rownum as seqno,a.ins_code,a.ins_name,to_char(a.empl_DATE,'yyyy-mm-dd') empl_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
				      " to_char(a.qual_date,'yyyy-mm-dd') qual_date,a.sex_g,a.tel_no,(select count(lecture_code) from Infolecture  where ins_code = a.ins_code) as lect_cnt  "
				      + " from InfoInstructor a where a.retire_date is null order by a.ins_code desc ";
					System.out.println("KKKKKKKK sql1 [" + sql + "]");
		}else {
			
		}
		
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				int seqno 				= resultSet.getInt("seqno");
				int ins_code 			= resultSet.getInt("ins_code");
				String ins_name 		= resultSet.getString("ins_name");
				String empl_date 		= resultSet.getString("empl_date");
				String retire_date 		= resultSet.getString("retire_date");
				String qual_date 		= resultSet.getString("qual_date");
				int sex_g 				= resultSet.getInt("sex_g");
				String tel_no 			= resultSet.getString("tel_no");
				int lect_cnt 			= resultSet.getInt("lect_cnt");

				InfoInstructorVO InfoInstructor = new InfoInstructorVO(seqno,ins_code, ins_name, empl_date, retire_date, qual_date, sex_g, tel_no,lect_cnt);

				InfoInstructorList.add(InfoInstructor);
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

		return InfoInstructorList;

	}
	
	public InfoInstructorVO getInfoInstructor(int iins_code) {

		InfoInstructorVO InfoInstructor = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from InfoInstructor where ins_code = ?";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(iins_code));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				
				int seqno 					= resultSet.getInt("seqno");
				int ins_code 				= resultSet.getInt("ins_code");
				String ins_name 			= resultSet.getString("ins_name");
				String empl_date 		= resultSet.getString("empl_date");
				String retire_date 		= resultSet.getString("retire_date");
				String qual_date 		= resultSet.getString("qual_date");
				int sex_g 					= resultSet.getInt("sex_g");
				String tel_no 				= resultSet.getString("tel_no");
				int lect_cnt 				= resultSet.getInt("lect_cnt");

				InfoInstructor = new InfoInstructorVO(seqno,ins_code, ins_name, empl_date, retire_date, qual_date, sex_g, tel_no,lect_cnt);
				
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

		return InfoInstructor;

	}
	
	public int InfoInstructorInsert( String  ins_name, String empl_date,  String qual_date, int sex_g, String  tel_no) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "insert into InfoInstructor (ins_code, ins_name, empl_date, retire_date, qual_date, sex_g, tel_no)"
				+ " values ((select (nvl(max(ins_code),0)+1) from InfoInstructor), ? , to_date(?,'yyyymmdd'), null, to_date(?,'yyyymmdd'), ?,?)";
		
		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, 		ins_name);
			preparedStatement.setString(2, 		empl_date);
			preparedStatement.setString(3, 		qual_date);
			preparedStatement.setInt(4, 		sex_g);
			preparedStatement.setString(5, 		tel_no);
	        
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
	
	public int InfoInstructorModify(int ins_code,String  ins_name, Timestamp empl_date, Timestamp retire_date, Timestamp qual_date, int sex_g, String  tel_no) {

		InfoInstructorVO InfoInstructor = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "update InfoInstructor set ins_name = ?,empl_date=?,retire_date=?,qual_date=?,sex_g=?,tel_no=? where ins_code = ?";

		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, 		ins_name);
			preparedStatement.setTimestamp(2, 	empl_date);
			preparedStatement.setTimestamp(3, 	retire_date);
			preparedStatement.setTimestamp(4, 	qual_date);
			preparedStatement.setInt(5, 		sex_g);
			preparedStatement.setString(6, 		tel_no);
			preparedStatement.setInt(7, 		ins_code);
			
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
