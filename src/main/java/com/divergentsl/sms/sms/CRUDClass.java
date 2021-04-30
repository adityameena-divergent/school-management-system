package com.divergentsl.sms.sms;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.divergentsl.sms.entity.Classs;
import com.divergentsl.sms.service.ClassService;
import com.divergentsl.sms.service.ClassServiceImpl;
import com.zaxxer.hikari.util.SuspendResumeLock;

@Component
public class CRUDClass {

	public void classPanel() {
		while (true) {
			System.out.println("\n1. Add New Class");
			System.out.println("2. Search Class");
			System.out.println("3. List All Classes");
			System.out.println("4. Update Class");
			System.out.println("5. Delete Class");
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
		
		System.out.print("\nEnter Class Id : ");
		int classId = Integer.parseInt(sc.nextLine());
		
		System.out.print("\nEnter Class Name : ");
		String className = sc.nextLine();
		
		System.out.print("\nEnter Class Section");
		String classSection = sc.nextLine();
		
		System.out.print("\nEnter Teacher Id : ");
		int teacherId = Integer.parseInt(sc.nextLine());
		
		ClassService service = new ClassServiceImpl();
		
		service.add(classId, className, classSection, teacherId);
		
	}
	
	public void search() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Class Id : ");
		int classId = Integer.parseInt(sc.nextLine());
		
		ClassService service = new ClassServiceImpl();
		Classs c = service.searchById(classId);
		
		System.out.println("\n" + c);
		
	}
	
	public void list() {
		
		ClassService service = new ClassServiceImpl();
		List<Classs> list = service.listAll();
		
		System.out.println("--------------------------Class List------------------------------");
		for(Classs c : list) {
			System.out.println(c);
		}
		System.out.println("\n-------------------------------------------------------------------");
	}
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Class Id to Delete : ");
		
		int classId = Integer.parseInt(sc.nextLine());
		ClassService service = new ClassServiceImpl();
		service.deleteById(classId);
		
	}
	
}
