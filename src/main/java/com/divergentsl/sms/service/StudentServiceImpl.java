package com.divergentsl.sms.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divergentsl.sms.entity.Classs;
import com.divergentsl.sms.entity.Student;
import com.divergentsl.sms.entity.Subject;
import com.divergentsl.sms.sms.SchoolManagementSystem;

public class StudentServiceImpl implements StudentService {

	
	@Override
	public void add(int studentId, String firstName, String lastName, int classId) {
		
		
		Student student = new Student();
		
		student.setId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		Session session = SchoolManagementSystem.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		
		tx.commit();
    	session.close();
		
		
	}


	@Override
	public Student searchById(int id) {
	
		Session session = SchoolManagementSystem.factory.openSession();
		
		Student student = session.get(Student.class, id);
		
		session.close();
		
		return student;
	}


	@Override
	public List<Student> listAll() {
		
		Session session = SchoolManagementSystem.factory.openSession();
		
		List<Student> list = session.createCriteria(Student.class).list();
		
	    session.close();
		return list;
	}


	@Override
	public void update(int id) {
		
		Session session = SchoolManagementSystem.factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
//		session.save(subject);
		
		tx.commit();
    	session.close();
	}

	
	@Override
	public void deleteById(int studentId) {
		
		Student student = this.searchById(studentId);
		
		Session session = SchoolManagementSystem.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		if(student != null)
			session.remove(student);
		
		tx.commit();
		session.close();
	}
	
}
