package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.util.InputUtil;
import com.cg.valid.InputValidation;
import com.cg.eis.service.EmployeeServiceImpl;
import com.cg.eis.service.IEmployeeService;

public class MainController {
	static IEmployeeService employeeService=new EmployeeServiceImpl();
	public static void main(String ar[]) {
		runApplication();													
	}
	
	public static void runApplication() {
	Scanner scanner = InputUtil.getScanner();						

	Boolean action = true;

	while (action) {

		System.out.println("Welcome:");
			
			System.out.println("enter your code : 1-View all Profiles ,2-Delete Profile, 3-Get Details based on Insurance Scheme, 4-Add an Employee");
			int choice=scanner.nextInt();
			
			InputValidation.result(choice);                          
			if (choice==1) {
				System.out.println("List of all the employees:");
				employeeService.viewEmployee();
			}
			else if(choice==2) {
				System.out.println("Enter the id of the employee you want to delete:");
				int id=scanner.nextInt();
				System.out.println("Updated list of employees:");
				employeeService.deleteEmployee(id);
			}
			else if(choice==3) {
				System.out.println("Enter the insurance scheme of the employees you want to see:");
				String insurance=scanner.next();
				employeeService.showProfile(insurance);
			}
			else if(choice==4) {
				System.out.println("Enter the id,name,salary of the new employee:");
				int id=scanner.nextInt();
				String name=scanner.next();
				int salary=scanner.nextInt();
				
				employeeService.addProfile(id,name,salary);
				System.out.println("Employee added successfully");
			}
	}
	scanner.close();
	}
}