package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDaoImpl;
import com.cg.eis.dao.IEmployeeDao;
import com.cg.eis.exception.SalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
	private static IEmployeeDao employeeDao;						//declaring an object 
	
	public EmployeeServiceImpl() {
		if(employeeDao==null) {										
			employeeDao=new EmployeeDaoImpl();
		}
	}
	
	@Override
	public boolean deleteEmployee(int id) {										//method Delete Employee
		employeeDao.deleteEmployee(id);
		return true;
	}

	@Override
	public Employee viewEmployee() {											//Method View Employee
		employeeDao.viewEmployee();
		return null;
	}

	@Override
	public void showProfile(String scheme) {									//Method Show Profile
		employeeDao.showProfile(scheme);
	}

	@Override
	public void addProfile(int id, String name, int salary) {	
		SalaryException.ExceptionHandler(salary);									//Exception handling for wrong salary
		String designation="";
		String insuranceScheme="";
		
		if(salary<5000) {							//loops for inserting designation, scheme based on input salary
			designation="Clerk";
			insuranceScheme="NoScheme";
		}
		
		else if(salary>=5000 && salary<20000) {
			designation="System Associate";
			insuranceScheme="SchemeC";
		}
		
		else if(salary>=20000 && salary<40000) {
			designation="Programmer";
			insuranceScheme="SchemeB";
		}
		else if(salary>=40000) {
			designation="Manager";
			insuranceScheme="SchemeA";
		}

		Employee emp=new Employee(id,name,salary,designation,insuranceScheme);	
		employeeDao.addProfile(emp);
	}
}