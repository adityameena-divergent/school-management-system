package com.divergentsl.sms.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divergentsl.sms.entity.Classs;
import com.divergentsl.sms.entity.Student;
import com.divergentsl.sms.sms.SchoolManagementSystem;

public class ClassServiceImpl implements ClassService {

	@Override
	public void add(int classId, String className, String classSection, int teacherId) {

		Classs c = new Classs();
		c.setClassId(classId);
		c.setClassName(className);
		c.setClassSection(classSection);

		Session session = SchoolManagementSystem.factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(c);

		tx.commit();
		session.close();

	}

	@Override
	public Classs searchById(int classId) {

		Session session = SchoolManagementSystem.factory.openSession();

		Classs c = session.get(Classs.class, classId);

		session.close();

		return c;
	}

	@Override
	public List<Classs> listAll() {

		Session session = SchoolManagementSystem.factory.openSession();

		List<Classs> list = session.createCriteria(Classs.class).list();

		session.close();
		return list;
	}

	@Override
	public void deleteById(int classId) {
		
		Classs c = this.searchById(classId);
		
		Session session = SchoolManagementSystem.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		if(c != null)
			session.remove(c);
		
		tx.commit();
		session.close();

		
	}

}
