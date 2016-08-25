package com.servlet;

import java.io.*; //导入java.io包
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DBServlet extends HttpServlet {

	ServletConfig config = null; // 定义一个ServletConfig对象
	private String driverName = ""; // 定义私有字符串常量并初始化
	private String username = ""; // 定义的数据库用户名
	private String password = ""; // 定义的数据库连接密码
	private String dbName = ""; // 定义的数据库名
	private Connection conn; // 初始化连接
	private Statement stmt; // 初始化数据库操作
	ResultSet rs = null; // 初始化结果集

	public void init(ServletConfig config) throws ServletException {
		super.init(config); // 继承父类的init()方法
		this.config = config; // 获取配置信息
		driverName = config.getInitParameter("driverName");// 从配置文件中获取JDBC驱动名
		username = config.getInitParameter("username"); // 获取数据库用户名
		password = config.getInitParameter("password"); // 获取数据库连接密码
		dbName = config.getInitParameter("dbName"); // 获取要连接的数据库
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		resp.setContentType("text/html;charset=GBK"); // 设置字符编码格式
		PrintWriter out = resp.getWriter(); // 实例化对象，用于页面输出
		out.println("<html>"); // 实现生成静态Html
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\"content=\"text/html;charset=GBK\">");
		out.println("<title>DataBase Connection</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<center>");
		String url = "jdbc:mysql://127.0.0.1:3306/userinfo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
			stmt = conn.createStatement();
			String name = req.getParameter("name");
			String passWord = req.getParameter("pass");
//			String sql = "select * from info";
			String sql ="insert into info(username,password) value('"+name+"','"+passWord+"')";
			stmt.execute(sql);
//			rs = stmt.executeQuery(sql);
//			out.println("Servlet访问数据库成功");
//			out.println("<table border=1 bordercolorlight=#000000>");
//			out.println("<td>用户名</td>");
//			out.println("<td>用户密码</td>");
//			while (rs.next()) {
//				out.println("<tr><td>" + rs.getString(1) + "</td>");
//				out.println("<td>" + rs.getString(2) + "</td>");
//				//
//				out.println("<tr>");
//			}
			out.println("登陆成功");
//			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			out.println(e.toString());
		}
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		this.doGet(req, resp);
	}

	public void destory() {
		config = null;
		driverName = null;
		username = null;
		password = null;
		dbName = null;
		conn = null;
		stmt = null;
		rs = null;
	}
}
