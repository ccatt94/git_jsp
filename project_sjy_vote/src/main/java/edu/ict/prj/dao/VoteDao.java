package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.MemberVO;
import edu.ict.prj.vo.RankVO;
import edu.ict.prj.vo.VoteVO;

public class VoteDao {

	private DataSource dataSource = null;

	public VoteDao() {
		try {
			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/tomboy");
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> showMember() {
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select m_no, m_name, m1.p_code,"
					+ " p_name, p_school, substr(m_jumin,1,6)||'-'||substr(m_jumin,7,7) m_jumin,"
					+ " m_city, p_tel1, p_tel2, p_tel3"
					+ " from tbl_member m1,"
					+ " tbl_party p1"
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
		String sql = "insert into tbl_vote (v_jumin, v_name, m_no, v_time, v_area, v_confirm) values (?,?,?,?,?,?)";
		
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

	public List<VoteVO> showVoteList() {
		
		List<VoteVO> voteList = new ArrayList<VoteVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
        DateTimeFormatter birthdayFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

		String sql = "select * from tbl_vote";
		

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(resultSet.toString());

			while (resultSet.next()) {
				
				String v_name = resultSet.getString("v_name");
                String birthday = resultSet.getString("V_JUMIN").substring(0, 6);

                LocalDate birthDate;
                try {
                    // 생년월일 처리
                    int year = Integer.parseInt(birthday.substring(0, 2));
                    int month = Integer.parseInt(birthday.substring(2, 4));
                    int day = Integer.parseInt(birthday.substring(4, 6));

                    year = year >= 0 && year <= 21 ? year + 2000 : year + 1900;

                    birthDate = LocalDate.of(year, month, day);
                } catch (DateTimeParseException | NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }

                LocalDate now = LocalDate.now();

                String age = String.valueOf(Period.between(birthDate, now).getYears());
                String gender = resultSet.getString("V_JUMIN").length() > 6 && resultSet.getString("V_JUMIN").charAt(6) == '1' ? "남" : "여";
                String v_time = resultSet.getString("v_time").substring(0, 2) + ":" + resultSet.getString("v_time").substring(2, 4);
                
                String v_confirm = resultSet.getString("v_confirm");
				
				if(v_confirm.equals("Y")) {
					v_confirm = "확인";
				}else {
					v_confirm = "미확인";
				}
				
				VoteVO m = new VoteVO(v_name, birthDate.format(outputFormatter), age, gender, resultSet.getString("M_NO"), v_time, v_confirm);
				
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

	public List<RankVO> memberRank() {
		List<RankVO> rankList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select m1.m_no, m_name, count(*) v_confirm from tbl_vote v1, tbl_member m1 "
				   + "where v1.m_no = m1.m_no and v_confirm='Y' group by m1.m_no, m_name "
				   + "order by v_confirm desc";
		

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(resultSet.toString());

			while (resultSet.next()) {
				
				String m_no = resultSet.getString("m_no");
				String m_name = resultSet.getString("m_name");
				String v_count = resultSet.getString("v_confirm");
				
				System.out.println(m_no);
				System.out.println(m_name);
				System.out.println(v_count);
				
				RankVO r = new RankVO(m_no, m_name, v_count);
				
				rankList.add(r);

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

		return rankList;
	}
	

}
