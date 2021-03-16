package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public interface IEmployeeService {

	public boolean deleteEmployee(int id);
	
	public Employee viewEmployee();
	
	public void showProfile(String scheme);

	public void addProfile(int id, String name, int salary);

}
