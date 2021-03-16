package com.cg.eis.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.cg.eis.bean.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	
	static Scanner scanner=new Scanner(System.in);
	public Map<Integer,Employee> employee = new HashMap<Integer,Employee>();           //Hashmap creation
	
	public boolean deleteEmployee(int id) {                                            //Method Delete Employee
		employee.remove(id);
		return true;
	}
	
	public void viewEmployee()                                                      //Method View Employee
	{
		for(Map.Entry<Integer,Employee> entry:this.employee.entrySet()) 
		{
			Employee value=entry.getValue();
			System.out.println(entry.getKey()+"---"+value.getName()+"--"+value.getSalary()+"---"+value.getDesignation()+"---"+value.getInsuranceScheme());
		}		
	}
	
	public void showProfile(String scheme) {											 //Method Show Profile
		List<Employee> people=new ArrayList<>();                                         //creating a list of type Employee
		for(Map.Entry<Integer,Employee> entry:this.employee.entrySet()) {		    //getting values that match scheme name
			Employee value=entry.getValue();
			if(value.getInsuranceScheme().equals(scheme)) {			
				people.add(value);
			}
		}
	
	for(Employee emp:people) {
		System.out.println(emp.getId()+":"+emp.getName()+":"+emp.getSalary()+":"+emp.getDesignation()+":"+emp.getInsuranceScheme());
	}
	}
	
	@Override
	public boolean addProfile(Employee emp) {
		employee.put(emp.getId(), emp);
		return true;
	}
}