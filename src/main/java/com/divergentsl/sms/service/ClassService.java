package com.divergentsl.sms.service;

import java.util.List;

import com.divergentsl.sms.entity.Classs;

public interface ClassService {

	
	public void add(int classId, String className, String classSection, int teacherId);
	
	public Classs searchById(int classId);
	
	public List<Classs> listAll();
	
	public void deleteById(int classId);
	
	
}
