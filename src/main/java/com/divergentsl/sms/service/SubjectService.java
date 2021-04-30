package com.divergentsl.sms.service;

import java.util.List;

import com.divergentsl.sms.entity.Subject;

public interface SubjectService {

	public void add(int id, String name);
	
	public Subject searchById(int id);
	
	public List<Subject> listAll();
	
	public void update(int id);
	
	public void deleteById(int subjectId);
	
}
