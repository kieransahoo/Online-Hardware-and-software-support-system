package com.app.dao;

import java.util.List;

import com.app.bean.Complaint;
import com.app.bean.Engineer;
import com.app.exceptions.ComplaintException;
import com.app.exceptions.EngineerException;
import com.app.exceptions.HODException;

public interface HODDao {
	public String loginHOD(String username, String password) throws HODException;
	
	public String registerEngineer(Engineer engineer);
	
	public List<Engineer> getAllEngineerDetails() throws EngineerException;
	
	public String deleteEngineer(int engId) throws EngineerException;
	
	public List<Complaint> getAllComplaintList() throws ComplaintException;
	 
	public String assignComplaintToEngineer(int cId,int engId) throws EngineerException,ComplaintException;
	
}
