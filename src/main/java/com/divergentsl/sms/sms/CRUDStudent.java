package com.divergentsl.sms.sms;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.divergentsl.sms.entity.Student;
import com.divergentsl.sms.service.StudentService;
import com.divergentsl.sms.service.StudentServiceImpl;

@Component
public class CRUDStudent {


	public void studentPanel() {
		while (true) {
			System.out.println("\n1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. List All Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
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
		System.out.print("\nEnter Student Id : ");
		int studentId = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter First Name : ");
		String firstName = sc.nextLine();
		
		System.out.print("\nEnter Last Name : ");
		String lastName = sc.nextLine();
		
		System.out.print("\nEnter Class Id : ");
		int classId = Integer.parseInt(sc.nextLine());
		
		StudentService service = new StudentServiceImpl();
		
		service.add(studentId, firstName, lastName, classId);
	}
	
	public void search() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Student Id : ");
		int studentId = Integer.parseInt(sc.nextLine());
		
		StudentService service = new StudentServiceImpl();
		
		Student student = service.searchById(studentId);
		
		System.out.println(student);
	}
	
	public void list() {
		
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.listAll();
		
		System.out.println("---------------------Student List------------------------------");
		for(Student student : list) {
			System.out.println("\n" + student);
		}
	}
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Student Id : ");
		int studentId = Integer.parseInt(sc.nextLine());
		StudentService service = new StudentServiceImpl();
		service.deleteById(studentId);
	}
	
}
