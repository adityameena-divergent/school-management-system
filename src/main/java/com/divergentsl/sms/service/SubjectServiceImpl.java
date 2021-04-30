package com.divergentsl.sms.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.divergentsl.sms.entity.Subject;
import com.divergentsl.sms.sms.SchoolManagementSystem;


@Service
public class SubjectServiceImpl implements SubjectService {
		
	@Override
	public void add(int id, String name) {
		
		Subject subject = new Subject();
	
		subject.setId(id);
		subject.setName(name);
		
		Session session = SchoolManagementSystem.factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(subject);
		
		tx.commit();
    	session.close();
		
		
	}


	@Override
	public Subject searchById(int id) {
	
		Session session = SchoolManagementSystem.factory.openSession();
		
		Subject subject = session.get(Subject.class, id);
		
		session.close();
		
		return subject;
	}


	@Override
	public List<Subject> listAll() {
		
		Session session = SchoolManagementSystem.factory.openSession();
		
		
		List<Subject> list = session.createCriteria(Subject.class).list();
		
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
	public void deleteById(int subjectId) {
		
		Subject subject = this.searchById(subjectId);
		
		Session session = SchoolManagementSystem.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		if(subject != null)
			session.remove(subject);
		
		tx.commit();
		session.close();

		
	}


	
}
