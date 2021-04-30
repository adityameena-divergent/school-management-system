package com.divergentsl.sms.sms;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.divergentsl.sms.entity.Teacher;
import com.divergentsl.sms.service.TeacherService;
import com.divergentsl.sms.service.TeacherServiceImpl;

@Component
public class CRUDTeacher {

	public void teacherPanel() {
		while (true) {
			System.out.println("\n1. Add Teacher");
			System.out.println("2. Search Teacher");
			System.out.println("3. List All Teacher");
			System.out.println("4. Update Teacher");
			System.out.println("5. Delete Teacher");
			System.out.println("6. Exit");

			Scanner sc = new Scanner(System.in);

			switch (sc.nextLine()) {
			case "1":
				this.add();
				break;
				
			case "2":
				this.search();
				break;
				
			case "3":
				this.list();
				break;
				
			case "5":
				this.delete();
				break;

			case "6":
				System.exit(0);
				break;
				
			default:
				break;
			}
		}
	}
	
	public void add() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Teacher Id : ");
		int teacherId = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Teacher First Name : ");
		String firstName = sc.nextLine();
		
		System.out.print("\nEnter Teacher Last Name : ");
		String lastName = sc.nextLine();
		
		System.out.print("\nEnter Teacher Id : ");
		int subjectId = Integer.parseInt(sc.nextLine());
		
		TeacherService service = new TeacherServiceImpl();
		service.add(teacherId, firstName, lastName, subjectId);
		
	}
	
	public void search() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Teacher Id : ");
		int teacherId = Integer.parseInt(sc.nextLine());
		
		TeacherService service = new TeacherServiceImpl();
		Teacher teacher = service.searchById(teacherId);
		
		System.out.println(teacher);
	}
	
	public void list() {
		
		TeacherService service = new TeacherServiceImpl();
		List<Teacher> list = service.listAll();
		
		System.out.println("\n------------------------------Teachers List--------------------------------");
		
		for(Teacher teacher : list) {
			System.out.println(teacher);
		}
		System.out.println("\n----------------------------------------------------------------------------");
	}
	
	public void delete() {
		
		Scanner sc = new Scanner(System.in);
		TeacherService service = new TeacherServiceImpl();
		int teacherId = Integer.parseInt(sc.nextLine());
		service.deleteById(teacherId);
		
	}
	
}
