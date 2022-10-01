package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Complaint;
import com.app.bean.Employee;
import com.app.exceptions.EmployeeException;
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

	@Override
	public String EmployeeLogin(String email, String password) throws EmployeeException {
		String message = "Invalid username or password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where empemail=? AND emppassword=?");
			
			ps.setString(1,email);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				message = "Login Successfull";
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return message;
	}

	@Override
	public String ChangePassword(String email, String password) throws EmployeeException {
		String message = "Invalid password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set emppassword=? where empemail=? ");
			
			ps.setString(1,password);
			ps.setString(2,email);
			
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				message = "password changed successfully !";
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String registerComplaint(Complaint complaint) {
		String message = "Invalid complaint";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into complaint(category,status,empid) value(?,?,?)");
			
			ps.setString(1,complaint.getCategory());
			ps.setString(2,complaint.getStatus());
			ps.setInt(3, complaint.getEmpid());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Comaplaint Registered Successfully !";
			
		}catch(SQLException e){
			
			message = e.getMessage();
			
		}
		
		
		return message;
	}

	@Override
	public List<Complaint> ComplaintList(int empId) throws EmployeeException {
		
		List <Complaint> complaintList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaint where empid=?");
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("compid");
				String c = rs.getString("category");
				String s = rs.getString("status");
				int epi = rs.getInt("empid");
				int egi = rs.getInt("engid");
				
				Complaint complaint = new Complaint(i,c,s,epi,egi);
				complaintList.add(complaint);
			}
			
		}catch(SQLException e){
			
			throw new EmployeeException(e.getMessage());
			
		}
		
		if(complaintList.size() == 0)
			throw new EmployeeException("No Complaint found..");
		return complaintList;
	}
	
	
}
