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
		
		//답변이 하나 달릴때마다 bStep+1을 해서 지정하게 되는데, 정렬에 대한 순서는 원본글에 대한 순서가 우선이기 때문에
		//id로 내림차순 후 bGroup으로 내림차순, 이후에 bStep으로 오름차순해서 정렬한다.
		String sql = "select * from mvc_board order by bgroup desc, bstep asc";
		
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
		
		//upHit(id);
		
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

	
	
	public int delete(String id) { //delete update insert 는 resultSet이 필요없음 excuteUpdate함수 사용
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "delete from mvc_board where bid = ?";
		
		int rn = 0;
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(id));  //sql의 첫번째 물음표에 id값 넣음
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

	public int write(String bname, String btitle, String bcontent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//sql은 컬럼명 대소문자 구분안해서 굳이 안바꿔도 됨
		String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ? , ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		
		int rn = 0;
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, bname);  
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			
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

	
	public BoardVO replyView(String id) { //댓글
		
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

	
	private void replyShape(String group, String step) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "update mvc_board set bstep = bstep + 1 where bgroup = ? and bstep > ?";

		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.parseInt(group));  
			preparedStatement.setInt(2, Integer.parseInt(step));  
			
			
			int rn = preparedStatement.executeUpdate();
			
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
	
	}
	
	
	public int reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep, String bindent) {
		
		replyShape(bgroup, bstep);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//sql은 컬럼명 대소문자 구분안해서 굳이 안바꿔도 됨
		String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		int rn = 0;
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, bname);  
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			
			preparedStatement.setInt(4, Integer.valueOf(bgroup));  
			preparedStatement.setInt(5, Integer.valueOf(bstep) + 1);  
			preparedStatement.setInt(6, Integer.valueOf(bindent) + 1);  

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

	public int modify(String bid, String bname, String btitle, String bcontent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//sql은 컬럼명 대소문자 구분안해서 굳이 안바꿔도 됨
		String sql = "update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid = ?";
		
		int rn = 0;
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			
			preparedStatement.setString(1, bname);  
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.parseInt(bid));
			
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
	
	public int upHit(String id) { 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "update mvc_board set bhit = bhit + 1 where bid = ?";
		
		int rn = 0;
		
		try{
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(id));  //sql의 첫번째 물음표에 id값 넣음
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
	
}
