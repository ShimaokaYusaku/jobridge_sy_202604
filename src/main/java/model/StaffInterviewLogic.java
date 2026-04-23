package model;

import dao.StaffInterviewsDAO;

public class StaffInterviewLogic {

	  public boolean execute_siv(StaffInterview siv, LoginStaffAccount staffaccount3) { 
		  StaffInterviewsDAO asrdao = new StaffInterviewsDAO();
		  boolean result =asrdao.create_siv(siv, staffaccount3);
	    return result;
	  }
	}

