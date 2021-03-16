package com.cg.eis.dao;

import com.cg.eis.bean.Employee;

public interface IEmployeeDao {
	
	public boolean deleteEmployee(int id);
	
	public void viewEmployee();
	
	public void showProfile(String scheme);
	
	boolean addProfile(Employee emp);

}
