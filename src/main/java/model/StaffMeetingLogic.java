package model;

import dao.StaffMeetingsDAO;

public class StaffMeetingLogic {

	  public boolean execute_smt(StaffMeeting smt, LoginStaffAccount staffaccount3) { 
		  StaffMeetingsDAO asrdao = new StaffMeetingsDAO();
		  boolean result =asrdao.create_smt(smt, staffaccount3);
	    return result;
	  }
	}

