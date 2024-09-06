package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.InfoMemberVO;

public class InfoMemberDao {

	private DataSource dataSource = null;

	public InfoMemberDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public ArrayList<InfoMemberVO> list(String v_confirm) {
		ArrayList<InfoMemberVO> InfoMemberList = new ArrayList<InfoMemberVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

	//	String sql = "select * from InfoMember order by memb_code";

		String sql = "";
		
		if (Integer.valueOf(v_confirm) == 1) {	// 정상고객일때
			sql = "select rownum as seqno,a.memb_code,a.memb_name,to_char(a.birth_date,'yyyy-mm-dd') birth_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
		      " to_char(a.join_date,'yyyy-mm-dd') join_date,a.sex_g,a.tel_no,a.juso,a.grade  "
		      + " from InfoMember a where a.retire_date is null order by a.memb_code ";
			System.out.println("KKKKKKKK sql1 [" + sql + "]");
		}	
		else if (Integer.valueOf(v_confirm) == 2) { // 탈퇴고객
			sql = "select rownum as seqno,a.memb_code,a.memb_name,to_char(a.birth_date,'yyyy-mm-dd') birth_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
				      " to_char(a.join_date,'yyyy-mm-dd') join_date,a.sex_g,a.tel_no,a.juso,a.grade  "
		      + "from InfoMember a where a.retire_date is not null order by a.memb_code ";
			System.out.println("KKKKKKKK sql2 [" + sql + "]");
		}	
		else if (Integer.valueOf(v_confirm) == 3) {  // 전체고객	
			sql = "select rownum as seqno,a.memb_code,a.memb_name,to_char(a.birth_date,'yyyy-mm-dd') birth_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
				      " to_char(a.join_date,'yyyy-mm-dd') join_date,a.sex_g,a.tel_no,a.juso,a.grade  "
		     + "from InfoMember a order by a.memb_code";
			System.out.println("KKKKKKKK sql3 [" + sql + "]");
		}
		else if (Integer.valueOf(v_confirm) == 4) {  // 정상고객중 최근등록고객순 조회	
			sql = "select rownum as seqno,a.memb_code,a.memb_name,to_char(a.birth_date,'yyyy-mm-dd') birth_date, to_char(a.retire_date,'yyyy-mm-dd') retire_date," + 
				      " to_char(a.join_date,'yyyy-mm-dd') join_date,a.sex_g,a.tel_no,a.juso,a.grade  "
				      + " from InfoMember a where a.retire_date is null order by a.memb_code desc ";
					System.out.println("KKKKKKKK sql1 [" + sql + "]");
		}else {
			
		}
			
			
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int seqno 				= resultSet.getInt("seqno");
				int memb_code 			= resultSet.getInt("memb_code");
				String memb_name 		= resultSet.getString("memb_name");
				String birth_date 		= resultSet.getString("birth_date");
				int sex_g 				= resultSet.getInt("sex_g");
				String tel_no 			= resultSet.getString("tel_no");
				String juso 			= resultSet.getString("juso");
				int grade 				= resultSet.getInt("grade");
				String join_date 		= resultSet.getString("join_date");
				String retire_date 		= resultSet.getString("retire_date");

				InfoMemberVO InfoMember = new InfoMemberVO(seqno,memb_code, memb_name, birth_date, sex_g, tel_no, juso, grade,join_date,retire_date);
	System.out.println("KKKKKKKK dddddd [" + seqno + "]");
				InfoMemberList.add(InfoMember);
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

		return InfoMemberList;

	}
	
	public InfoMemberVO getInfoMember(int imemb_code) {

		InfoMemberVO InfoMember = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from InfoMember where memb_code = ?";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(imemb_code));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				
				int seqno 				= resultSet.getInt("seqno");
				int memb_code 			= resultSet.getInt("memb_code");
				String memb_name 		= resultSet.getString("memb_name");
				String birth_date 		= resultSet.getString("birth_date");
				int sex_g 				= resultSet.getInt("sex_g");
				String tel_no 			= resultSet.getString("tel_no");
				String juso 			= resultSet.getString("juso");
				int grade 				= resultSet.getInt("grade");
				String join_date 		= resultSet.getString("join_date");
				String retire_date 		= resultSet.getString("retire_date");

				InfoMember = new InfoMemberVO(seqno,memb_code, memb_name, birth_date, sex_g, tel_no, juso, grade,join_date,retire_date);
				
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

		return InfoMember;

	}
	
	public int InfoMemberInsert(String  memb_name,String birth_date,int sex_g,String  tel_no,String  juso,int grade) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "insert into InfoMember (memb_code,memb_name,birth_date,sex_g,tel_no,juso,grade,join_date,retire_date)"
				+ " values ((select (nvl(max(memb_code),0)+1) from InfoMember), ? , to_date(?,'yyyymmdd'), ?, ?, ?, ?, sysdate, null) ";
		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, 		memb_name);
			preparedStatement.setString(2, 		birth_date);
			preparedStatement.setInt(3, 		sex_g);
			preparedStatement.setString(4, 		tel_no);
			preparedStatement.setString(5, 		juso);
			preparedStatement.setInt(6, 		grade);
	        
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
	
	public int InfoMemberModify(int memb_code,String  memb_name,Timestamp birth_date,int sex_g,String  tel_no,String  juso,int grade,Timestamp join_date,Timestamp retire_date) {

		InfoMemberVO InfoMember = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "update InfoMember set memb_name = ?,birth_date=?,sex_g=?,tel_no=?,juso=?,grade=?,join_date=?,retire_date=? where memb_code = ?";

		int rn = 0;
		
		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, 		memb_name);
			preparedStatement.setTimestamp(2, 	birth_date);
			preparedStatement.setInt(3, 		sex_g);
			preparedStatement.setString(4, 		tel_no);
			preparedStatement.setString(5, 		juso);
			preparedStatement.setInt(6, 		grade);
			preparedStatement.setTimestamp(7, 	join_date);
			preparedStatement.setTimestamp(8, 	retire_date);
			preparedStatement.setInt(9, 		memb_code);
			
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
