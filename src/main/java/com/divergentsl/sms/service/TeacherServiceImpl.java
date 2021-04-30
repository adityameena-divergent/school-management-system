package com.divergentsl.sms.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.divergentsl.sms.entity.Subject;
import com.divergentsl.sms.entity.Teacher;
import com.divergentsl.sms.sms.SchoolManagementSystem;

public class TeacherServiceImpl implements TeacherService {

	@Override
	public void add(int teacherId, String firstName, String lastName, int subjectId) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherId);
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);

		Session session = SchoolManagementSystem.factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(teacher);

		tx.commit();
		session.close();
	}

	@Override
	public Teacher searchById(int id) {
		Session session = SchoolManagementSystem.factory.openSession();

		Teacher teacher = session.get(Teacher.class, id);

		session.close();

		return teacher;
	}

	@Override
	public List<Teacher> listAll() {
		Session session = SchoolManagementSystem.factory.openSession();

		List<Teacher> list = session.createCriteria(Teacher.class).list();

		session.close();
		return list;
	}

	@Override
	public void update(int id) {

	}

	@Override
	public void deleteById(int teacherId) {
		Teacher teacher = this.searchById(teacherId);

		Session session = SchoolManagementSystem.factory.openSession();
		Transaction tx = session.beginTransaction();

		if (teacher != null)
			session.remove(teacher);

		tx.commit();
		session.close();

	}

}
