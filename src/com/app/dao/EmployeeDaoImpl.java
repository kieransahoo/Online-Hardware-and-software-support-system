package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.bean.Employee;
import com.app.utility.DBUtil;


public class EmployeeDaoImpl implements EmployeeDao{

	
	@Override
	public String registerEmployee(Employee employee) {
		String message = "Registered Successfully";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(empname,empemail,emppassword) value(?,?,?)");
			ps.setString(1, employee.getEmpname());
			ps.setString(2, employee.getEmpemail());
			ps.setString(3, employee.getEmppassword());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Registered Successfully !";
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}

	return message;
	}
	
}
