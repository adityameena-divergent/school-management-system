package com.divergentsl.sms.sms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CRUDMain {

	@Autowired
	private CRUDSubject crudSubject;
	
	@Autowired
	private CRUDStudent crudStudent;
	
	@Autowired
	private CRUDClass crudClass;
	
	@Autowired
	private CRUDTeacher crudTeacher;
	
	public void mainPanel() {
		
		while(true) {
			
			System.out.println("\n1. Student");
			System.out.println("2. Class");
			System.out.println("3. Teacher");
			System.out.println("4. Subject");
			System.out.println("5. Exit");
			
			Scanner sc = new Scanner(System.in);
			
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				crudStudent.studentPanel();
				break;
				
			case "2":
				crudClass.classPanel();
				break;
			
			case "3":
				crudTeacher.teacherPanel();
				break;
				
			case "4":
				crudSubject.subjectPanel();
				break;
				
			case "5":
				System.exit(0);
				break;

			default:
				break;
			}
			
		}
		
	}
	
}
