package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.MemberVO;
import edu.ict.prj.vo.VoteVO;

public class VoteDao {

	private DataSource dataSource = null;

	public VoteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/tomboy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberVO> showMember() {
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select m_no, m_name, m1.p_code,"
					+ " p_name, p_school, substr(m_jumin,1,6)||'-'||substr(m_jumin,7,7) m_jumin,"
					+ " m_city, p_tel1, p_tel2, p_tel3"
					+ " from tbl_member_202005 m1,"
					+ " tbl_party_202005 p1"
					+ " where m1.p_code = p1.p_code";
		

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(resultSet.toString());

			while (resultSet.next()) {
				
				String m_no = resultSet.getString("m_no");
				String m_name = resultSet.getString("m_name");
				String p_code = resultSet.getString("p_code");
				String p_school = resultSet.getString("p_school");
				String m_jumin = resultSet.getString("m_jumin");
				String m_city = resultSet.getString("m_city");
				
				String tel = resultSet.getString("p_tel1") + "-" + resultSet.getString("p_tel2") + "-" + resultSet.getString("p_tel3");
				
				MemberVO m = new MemberVO(m_no, m_name, p_code, p_school, m_jumin, m_city, tel);
				
				memberList.add(m);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {

			}

		}

		return memberList;

	}

	
	public int insert(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//sql은 컬럼명 대소문자 구분안해서 굳이 안바꿔도 됨
		String sql = "insert into tbl_vote_202005 (v_jumin, v_name, m_no, v_time, v_area, v_confirm) values (?,?,?,?,?,?)";
		
		int rn = 0;
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, v_jumin);  
			preparedStatement.setString(2, v_name);
			preparedStatement.setString(3, m_no);
			preparedStatement.setString(4, v_time);
			preparedStatement.setString(5, v_area);
			preparedStatement.setString(6, v_confirm);
			
			rn = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
		            
		         if(preparedStatement != null) 
		        	 preparedStatement.close();
		            
		         if(connection != null) 
		            connection.close();
				
			}catch (Exception e2) {

			}
			
		}
		
		
		
		return rn;
		
	}

	public ArrayList<VoteVO> showVoteList() {
		
		ArrayList<VoteVO> voteList = new ArrayList<VoteVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from tbl_vote_202005";
		

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(resultSet.toString());

			while (resultSet.next()) {
				
				String v_name = resultSet.getString("v_name");
				String v_jumin = resultSet.getString("v_jumin");
				
				if(v_jumin.substring(0, 1)!="0") {
					v_jumin = "19" + v_jumin.substring(0, 2) + "년" 
								   + v_jumin.substring(2, 4) + "월" 
								   + v_jumin.substring(4, 6) + "일생";
				}else {
					v_jumin = "20" + v_jumin.substring(0, 2) + "년" 
								   + v_jumin.substring(2, 4) + "월" 
								   + v_jumin.substring(4, 6) + "일생";
				}
				
				String v_age = resultSet.getString("v_jumin").substring(0, 2);
				LocalDate now = LocalDate.now();
				
				if(v_age.substring(0, 2)!="0") {
					
					try{
					int age = 1900 + Integer.parseInt(resultSet.getString("v_jumin").substring(0, 2));
					age = now.getYear() - age;
					v_age = "만 " + String.valueOf(age) + "세";
					}catch(Exception e) {}
					
				}else {
					
					try{
					int age = 2000 + Integer.parseInt(resultSet.getString("v_jumin").substring(0, 2));
					age = now.getYear() - age;
					v_age = "만 " + String.valueOf(age) + "세";
					}catch(Exception e) {}
					
				}
					
				String v_sex = resultSet.getString("v_jumin");
				
				if(v_sex.substring(6, 7).equals("1") || v_sex.substring(6, 7).equals("3")) {
					v_sex = "남";
				}else if(v_sex.substring(6, 7).equals("2") || v_sex.substring(6, 7).equals("4")) {
					v_sex = "여";
				}
				
				String m_no = resultSet.getString("m_no");
				String v_time = resultSet.getString("v_time").substring(0, 2) + " : " + resultSet.getString("v_time").substring(2, 4);
				String v_confirm = resultSet.getString("v_confirm");
				
				if(v_confirm.equals("Y")) {
					v_confirm = "확인";
				}else {
					v_confirm = "미확인";
				}
				
				VoteVO m = new VoteVO(v_name, v_jumin, v_age, v_sex, m_no, v_time, v_confirm);
				
				voteList.add(m);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {

			}

		}

		return voteList;
	}
	

}
