package com.marcind.database;

import java.sql.*;

public class DemoClass 
{
	public static void main(String[] args) throws Exception
	{
		Pass passw = new Pass();
		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "root";
		String pass = passw.p;
		int userid = 6; // variable for insert the data --> DML // 2nd version
		String username = "Dipali"; // variable for insert the data --> DML // 2nd version
//		String query = "select * from student"; // query for read the data --> DQL
//		String query = "insert into student values (4, 'Mohini')"; // query for insert the data --> DML // 1st version
//		String query = "insert into student values (" + userid + ",'" + username + "')"; // query for insert the data --> DML // 2nd version
		String query = "insert into student values (?,?)"; // query for insert the data --> DML // 3rd version
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
//		Statement st = con.createStatement(); // 1st and 2nd versions
		PreparedStatement st = con.prepareStatement(query); // 3rd version
		st.setInt(1, userid);
		st.setString(2, username);
//		ResultSet rs = st.executeQuery(query); // DQL
//		int count = st.executeUpdate(query); // DML // 2nd version
		int count = st.executeUpdate(); // DML // 3rd version
		
		System.out.println(count + " row/s affected");
		
//		while(rs.next()) // DQL
//		{
//		String userData = rs.getInt(1) + " : " + rs.getString(2);
//		System.out.println(userData);
//		}
		st.close();
		con.close();
		
	}
}
