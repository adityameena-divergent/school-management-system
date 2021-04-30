package com.divergentsl.sms.service;

import java.util.List;

import com.divergentsl.sms.entity.Student;

public interface StudentService {

public void add(int studentId, String firstName, String lastName, int classId);
	
	public Student searchById(int id);
	
	public List<Student> listAll();
	
	public void update(int id);
	
	public void deleteById(int studentId);
	
}
