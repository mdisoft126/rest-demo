package com.marcind.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDaoDemo {
	public static void main(String[] args)
	{
		StudentDAO dao = new StudentDAO();
		dao.connect();
//		Student s1 = dao.getStudent(11); // get
//		System.out.println(s1.sname); // get
		Student s2 = new Student();
		s2.rollno = 17;
		s2.sname = "Buton";
		dao.addStudent(s2);
	}

}

class StudentDAO
{
	Connection con = null;
	public void connect()
	{
		try {
			Pass passw = new Pass();
			String pass = passw.p;
			String url = "jdbc:mysql://localhost:3306/navin";
			String uname = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}
	public Student getStudent(int rollno)
	{

		try {
			String query = "select sname from student where rollno =" + rollno;
			Student s = new Student();
			s.rollno = rollno;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.sname = name;
			return s;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
	}
	public void addStudent(Student s)
	{
		String query = "insert into Student values (?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, s.rollno);
			pst.setString(2, s.sname);
			pst.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

class Student
{
	int rollno;
	String sname;
}
