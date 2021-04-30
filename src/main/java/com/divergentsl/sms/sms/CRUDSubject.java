package com.divergentsl.sms.sms;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.divergentsl.sms.entity.Subject;
import com.divergentsl.sms.service.SubjectService;
import com.divergentsl.sms.service.SubjectServiceImpl;

@Component
public class CRUDSubject {
	

	public void subjectPanel() {

		while (true) {

			System.out.println("\n1. Add Subject");
			System.out.println("2. Search Subject");
			System.out.println("3. List All Subject");
			System.out.println("4. Update Subject");
			System.out.println("5. Delete Subject");
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

		System.out.print("\nEnter Subject Id : ");
		int id = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Subject Name : ");
		String name = sc.nextLine();
		
		SubjectService service = new SubjectServiceImpl();
		
		service.add(id, name);
	}
	
	
	public void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Subject Id : ");
		int id = sc.nextInt();
		
		SubjectService service = new SubjectServiceImpl();
		Subject subject = service.searchById(id);
		
		System.out.println("\n" + subject);	
	}
	
	
	public void list() {
		SubjectService service = new SubjectServiceImpl();
		
		List<Subject> list = service.listAll();
		System.out.println("\n-----------------------------------------------");
		for(Subject subject: list) {
			System.out.println(subject);
		}
		
	}
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Subject Id : ");
		int subjectId = Integer.parseInt(sc.nextLine());

		SubjectService service = new SubjectServiceImpl();
		service.deleteById(subjectId);
	}

}
