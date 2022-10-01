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
import com.app.exceptions.EngineerException;
import com.app.exceptions.HODException;
import com.app.utility.DBUtil;

public class HODDaoImpl implements HODDao{

	@Override
	public String loginHOD(String username, String password) throws HODException {
		
		String message = "Invalid username or password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from HOD where username=? AND password=?");
			
			ps.setString(1,username);
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
	public List<Engineer> getAllEngineerDetails() throws EngineerException {
		
		List<Engineer> engineerList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from engineer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("engid");
				String n = rs.getString("engname");
				String e = rs.getString("engemail");
				String p = rs.getString("engpassword");
				
				Engineer engineer = new Engineer(i,n,e,p);
				engineerList.add(engineer);
			}
			
		}catch(SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		if(engineerList.size()==0)
			throw new EngineerException("No Engineers Found ..!");
		return engineerList;
		
	}

	@Override
	public String deleteEngineer(int engId) throws EngineerException {
		String message = "Invalid Engineer Id ";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from engineer where engid=?");
			
			ps.setInt(1, engId);
			int x = ps.executeUpdate();
			if(x>0)
				message = "Engineer Removed Successfully !";
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<Complaint> getAllComplaintList() throws ComplaintException {
		
		List<Complaint> complaintList = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaint");
			
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
			
		}catch(SQLException e) {
			throw new ComplaintException(e.getMessage());
		}
		
		if(complaintList.size() == 0)
			throw new ComplaintException("No Complaints Found ..!");
		
		return complaintList;
	}

	@Override
	public String assignComplaintToEngineer(int cId, int engId) throws EngineerException, ComplaintException {
		String message = "Not Assigned";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement(" update complaint set engid=? where compid=?");
			
			ps.setInt(1, engId);
			ps.setInt(2, cId);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Engineer Assigned Successfullt";
			}
			
		}catch(SQLException e) {
			throw new ComplaintException(e.getMessage());
		}
		
		return message;
		
	}
	
}
