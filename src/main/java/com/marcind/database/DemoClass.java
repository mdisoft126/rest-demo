package com.marcind.database;

import java.sql.*;

public class DemoClass 
{
	public static void main(String[] args) throws Exception
	{
		String url = "";
		String uname = "root";
		String pass = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
	}
}
