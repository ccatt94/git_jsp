<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//db접속 3종세트
		Connection connection;
		Statement statement;
		ResultSet rs;
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
		
		String query = "select e.ename, e.deptno, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno";
		
		try{
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				
				
				out.print("사원이름 : " + ename + "&nbsp");
				out.print("부서번호 : " + deptno + "&nbsp");
				out.print("부서이름 : " + dname + "&nbsp");
				out.print("부서위치 : " + loc + "&nbsp");
				out.print("<br>");
				
				
			}
			
			
		}catch(Exception e){}
		finally{}
		
		
		
	%>
	
				
	
</body>
</html>