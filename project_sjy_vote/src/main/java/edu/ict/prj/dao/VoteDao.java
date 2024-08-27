package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.VoteVO;

public class VoteDao {

	private DataSource dataSource = null;

	public VoteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<VoteVO> list() {
		ArrayList<VoteVO> voteList = new ArrayList<VoteVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from tbl_member_202005";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String m_no = resultSet.getString("m_no");
				String m_name = resultSet.getString("m_name");
				String p_code = resultSet.getString("p_code");
				String p_school = resultSet.getString("p_school");
				String m_jumin = resultSet.getString("m_jumin");
				String m_city = resultSet.getString("m_city");

				VoteVO vote = new VoteVO(m_no, m_name, p_code, p_school, m_jumin, m_city);

				voteList.add(vote);

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
