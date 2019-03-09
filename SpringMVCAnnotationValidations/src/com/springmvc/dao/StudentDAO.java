package com.springmvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

import com.springmvc.javabeans.StudentDetails;

public class StudentDAO implements IStudentDAO 
{
	
	private JdbcTemplate jdbcTemplate;
	
//	public void getJdbcTemplate(JdbcTemplate jdbcTemplate)
//	{
//		this.jdbcTemplate = jdbcTemplate;
//	}
	public StudentDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public Boolean addNewStudent(StudentDetails studentDetails) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<StudentDetails> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDetails getThisStudent(StudentDetails studentDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteThisStudent(StudentDetails studentDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCountOfStudents() {
		// TODO Auto-generated method stub
		return 0;
	}

}
