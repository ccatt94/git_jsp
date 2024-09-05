package edu.ict.prj.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import edu.ict.prj.vo.ShoppingMemberVO;
import edu.ict.prj.vo.ShoppingMoneyVO;

public class ShoppingDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ShoppingDao() {
	}

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.0.6:1521/xe", "Tomsboy", "fivecoding");
		return con;
	}

	public String nextCustno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.conn = getConnection();
			String sql = "SELECT max(custno)+1 custno FROM SHOPPING_MEMBER";
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			int custno = 0;
			if (this.rs.next()) {
				custno = this.rs.getInt(1);
			}

			request.setAttribute("custno", custno);
			this.conn.close();
			this.ps.close();
			this.rs.close();
		} catch (Exception var5) {
			Exception e = var5;
			e.printStackTrace();
		}

		return "add.jsp";
	}

	public String selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShoppingMemberVO> list = new ArrayList<>();

		try {
			this.conn = getConnection();
			String sql = "SELECT custno, custname, phone, address, TO_CHAR(joindate,'YYYY-MM-DD') joindate, DECODE(grade,'A','VIP','B','일반','직원') grade, city FROM SHOPPING_MEMBER ORDER BY custno";
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();

			while(this.rs.next()) {
				ShoppingMemberVO member = new ShoppingMemberVO();
				member.setCustno(this.rs.getInt(1));
				member.setCustname(this.rs.getString(2));
				member.setPhone(this.rs.getString(3));
				member.setAddress(this.rs.getString(4));
				member.setJoindate(this.rs.getString(5));
				member.setGrade(this.rs.getString(6));
				member.setCity(this.rs.getString(7));
				list.add(member);
			}

			request.setAttribute("list", list);
			this.conn.close();
			this.ps.close();
			this.rs.close();
		} catch (Exception var6) {
			Exception e = var6;
			e.printStackTrace();
		}

		return "list.jsp";
	}

	public String modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShoppingMemberVO> list = new ArrayList<>();

		try {
			this.conn = getConnection();
			int custno = Integer.parseInt(request.getParameter("custno"));
			String sql = "SELECT custname, phone, address, TO_CHAR(joindate,'YYYY-MM-DD') joindate, grade, city FROM SHOPPING_MEMBER WHERE custno =" + custno;
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			if (this.rs.next()) {
				ShoppingMemberVO member = new ShoppingMemberVO();
				member.setCustno(custno);
				member.setCustname(this.rs.getString(1));
				member.setPhone(this.rs.getString(2));
				member.setAddress(this.rs.getString(3));
				member.setJoindate(this.rs.getString(4));
				member.setGrade(this.rs.getString(5));
				member.setCity(this.rs.getString(6));
				list.add(member);
			}

			request.setAttribute("list", list);
			request.setAttribute("custno", custno);
			this.conn.close();
			this.ps.close();
			this.rs.close();
		} catch (Exception var7) {
			Exception e = var7;
			e.printStackTrace();
		}

		return "modify.jsp";
	}

	public String selectResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShoppingMoneyVO> list = new ArrayList<>();

		try {
			this.conn = getConnection();
			String sql = "SELECT m1.custno, m1.custname, DECODE(m1.grade,'A','VIP','B','일반','직원')grade, SUM(m2.price)price FROM SHOPPING_MEMBER m1, SHOPPING_MONEY m2 WHERE m1.custno = m2.custno GROUP BY (m1.custno, m1.custname, grade) ORDER BY price DESC";
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();

			while(this.rs.next()) {
				ShoppingMoneyVO money = new ShoppingMoneyVO();
				money.setCustno(this.rs.getInt(1));
				money.setCustname(this.rs.getString(2));
				money.setGrade(this.rs.getString(3));
				money.setPrice(this.rs.getInt(4));
				list.add(money);
			}

			request.setAttribute("list", list);
			this.conn.close();
			this.ps.close();
			this.rs.close();
		} catch (Exception var6) {
			Exception e = var6;
			e.printStackTrace();
		}

		return "result.jsp";
	}

	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");

		int result = 0;

		try {
			this.conn = getConnection();
			String sql = "INSERT INTO SHOPPING_MEMBER VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, custno);
			this.ps.setString(2, custname);
			this.ps.setString(3, phone);
			this.ps.setString(4, address);
			this.ps.setString(5, joindate);
			this.ps.setString(6, grade);
			this.ps.setString(7, city);
			
			result = this.ps.executeUpdate();

			System.out.println(result);
			this.conn.close();
			this.ps.close();
		} catch (Exception var12) {
			Exception e = var12;
			e.printStackTrace();
		}

		return "add";
	}

	public int update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		int result = 0;

		try {
			this.conn = getConnection();
			String sql = "UPDATE SHOPPING_MEMBER SET custname = ?, phone = ?, address = ?, joindate = TO_DATE(?,'YYYY-MM-DD'),  grade = ? , city = ? WHERE custno = ? ";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, custname);
			this.ps.setString(2, phone);
			this.ps.setString(3, address);
			this.ps.setString(4, joindate);
			this.ps.setString(5, grade);
			this.ps.setString(6, city);
			this.ps.setInt(7, custno);
			result = this.ps.executeUpdate();
			this.conn.close();
			this.ps.close();
		} catch (Exception var12) {
			Exception e = var12;
			e.printStackTrace();
		}

		return result;
	}

	public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;

		try {
			this.conn = getConnection();
			String custno = request.getParameter("custno");
			String sql = "DELETE FROM SHOPPING_MEMBER WHERE custno=" + custno;
			this.ps = this.conn.prepareStatement(sql);
			result = this.ps.executeUpdate();
			this.conn.close();
			this.ps.close();
		} catch (Exception var6) {
			Exception e = var6;
			e.printStackTrace();
		}

		return result;
	}
}