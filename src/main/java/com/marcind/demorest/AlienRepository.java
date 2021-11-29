	package com.marcind.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.marcind.database.Pass;

public class AlienRepository 
{
	Connection con = null;
	
	public AlienRepository()
	{
		try {
			Pass passw = new Pass();
			String pass = passw.p;
			String url = "jdbc:mysql://localhost:3306/restdb";
			String username = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);;
		}
	}
	// fetch all values
	public List<Alien> getAliens()
	{
		List<Alien> aliens = new ArrayList<Alien>();
		String sql = "select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return aliens;
	}
	
	public Alien getAlien(int id)
	{
		String sql = "select * from alien where id = " + id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public void create(Alien a1) {
		// TODO Auto-generated method stub
		aliens.add(a1);
	}
	
}
