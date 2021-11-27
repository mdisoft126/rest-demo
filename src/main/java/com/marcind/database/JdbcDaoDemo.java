package com.marcind.database;

public class JdbcDaoDemo {
	public static void main(String[] args)
	{
		StudentDAO dao = new StudentDAO();
		Student s1 = dao.getStudent(12);
		System.out.println(s1);
	}

}

class StudentDAO
{
	public Student getStudent(int rollno)
	{
		Student s = new Student();
		s.rollno = rollno;
		return s;
	}
}

class Student
{
	int rollno;
	String sname;
}
