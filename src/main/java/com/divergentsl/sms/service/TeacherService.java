package com.divergentsl.sms.service;

import java.util.List;

import com.divergentsl.sms.entity.Subject;
import com.divergentsl.sms.entity.Teacher;

public interface TeacherService {

	
	public void add(int teacherId, String firstName, String lastName, int subjectId);
	
	public Teacher searchById(int id);
	
	public List<Teacher> listAll();
	
	public void update(int id);
	
	public void deleteById(int teacherId);
	
}
