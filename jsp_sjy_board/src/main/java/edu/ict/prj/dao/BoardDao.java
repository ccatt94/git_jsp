package edu.ict.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.ict.prj.vo.BoardVO;

public class BoardDao {
	
	private DataSource dataSource = null;
	
	public BoardDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardVO> list(){
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from mvc_board";
		
		//java 9버전 이후는 try~catch -resource 사용 가능
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");
				Timestamp bdate = resultSet.getTimestamp("bdate");
				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");
				
				BoardVO board = new BoardVO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				
				boardList.add(board);
				
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if(resultSet != null) 
					resultSet.close();
		            
		         if(preparedStatement != null) 
		        	 preparedStatement.close();
		            
		         if(connection != null) 
		            connection.close();
				
			}catch (Exception e2) {

			}
			
		}
		
		return boardList;
	
	}

	
	public BoardVO getBoard(String id) {
		
		BoardVO board = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from mvc_board where bid = ?";
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(id));  //sql의 첫번째 물음표에 id값 넣음
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");
				Timestamp bdate = resultSet.getTimestamp("bdate");
				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");
				
				board = new BoardVO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				
				
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if(resultSet != null) 
					resultSet.close();
		            
		         if(preparedStatement != null) 
		        	 preparedStatement.close();
		            
		         if(connection != null) 
		            connection.close();
				
			}catch (Exception e2) {

			}
			
		}
		
		
		return board;
	}
	
	
	
}
