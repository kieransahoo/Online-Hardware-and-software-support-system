package com.app.dao;

import java.util.List;

import com.app.bean.Complaint;
import com.app.bean.Employee;
import com.app.exceptions.EmployeeException;

public interface EmployeeDao {
	public String registerEmployee(Employee employee);
	
	public String EmployeeLogin(String email, String password) throws EmployeeException;
	
	public String ChangePassword(String email,String password) throws EmployeeException;
	
	public String registerComplaint(Complaint complaint);
	
	public List<Complaint> ComplaintList(int empId) throws EmployeeException;
	
	
}
