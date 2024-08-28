package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		ArrayList<MemberVO> voteList = new ArrayList<MemberVO>();

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
		// TODO Auto-generated method stub
		return null;
	}
	

}
