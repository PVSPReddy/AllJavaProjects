package com.springmvc.dao;

import com.springmvc.javabeans.StudentDetails;

import java.util.List;

public interface IStudentDAO 
{

	Boolean addNewStudent(StudentDetails studentDetails);
	
	List<StudentDetails> getAllStudents();
	
	StudentDetails getThisStudent(StudentDetails studentDetails);
	
	void deleteThisStudent(StudentDetails studentDetails);
	
	void deleteAllStudents();
	
	int getCountOfStudents();
	
}
