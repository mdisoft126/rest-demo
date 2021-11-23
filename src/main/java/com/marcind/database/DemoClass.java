package com.marcind.database;

import java.sql.*;

public class DemoClass 
{
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "root";
		String pass = "";
		String query = "select username from student where userid = 3";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		String name = rs.getString("username");
		
		System.out.println(name);
		
		st.close();
		con.close();
		
	}
}
