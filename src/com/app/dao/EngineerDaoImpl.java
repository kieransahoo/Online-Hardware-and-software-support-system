package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Complaint;
import com.app.bean.Engineer;
import com.app.exceptions.ComplaintException;
import com.app.exceptions.EmployeeException;
import com.app.exceptions.EngineerException;
import com.app.utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public String registerEngineer(Engineer engineer) {
		String message = "Engineer Registered Successfully";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into engineer(engname,engemail,engpassword) value(?,?,?)");
			ps.setString(1, engineer.getEngname());
			ps.setString(2, engineer.getEngemail());
			ps.setString(3, engineer.getEngpassword());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Engineer Registered Successfully !";
			
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String EngineerLogin(String email, String password) throws EngineerException {
		String message = "Invalid username or password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from engineer where engemail=? AND engpassword=?");
			
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
	public String ChangePassword(String email, String password) throws EngineerException {
		String message = "Invalid password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update engineer set engpassword=? where engemail=? ");
			
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
	public List<Complaint> ComplaintList(int engId) throws EngineerException {
		List <Complaint> complaintList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaint where engid=?");
			
			ps.setInt(1, engId);
			
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
			
			throw new EngineerException(e.getMessage());
			
		}
		
		if(complaintList.size() == 0)
			throw new EngineerException("No Complaint found..");
		return complaintList;
	}

	@Override
	public String UpdateAssignedComplaintStatus(int compId, String status) throws ComplaintException {
		String message = "Invalid Complaint ID";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update complaint set status=? where compid=?");
			
			ps.setString(1, status);
			ps.setInt(2, compId);
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Complaint Status Updated !";
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}
		
		return message;
	}

	

	

}
