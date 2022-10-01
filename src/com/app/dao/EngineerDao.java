package com.app.dao;


import java.util.List;

import com.app.bean.Complaint;
import com.app.bean.Engineer;
import com.app.exceptions.ComplaintException;
import com.app.exceptions.EngineerException;


public interface EngineerDao {
	public String registerEngineer(Engineer engineer);
	
	public String EngineerLogin(String email, String password) throws EngineerException;
	
	public String ChangePassword(String email,String password) throws EngineerException;
	
	public List<Complaint> ComplaintList(int engId)throws EngineerException;
	
	public String UpdateAssignedComplaintStatus(int compId,String status)throws ComplaintException;
	
	
	
}
