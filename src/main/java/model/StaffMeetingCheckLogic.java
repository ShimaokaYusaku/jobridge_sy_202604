package model;

import java.util.List;

import dao.StaffMeetingChecksDAO;

public class StaffMeetingCheckLogic {

	  public List<StaffMeetingCheckList> execute_smtc(StaffMeetingCheck smtc) { 
		  StaffMeetingChecksDAO smtcdao = new StaffMeetingChecksDAO();
		  List<StaffMeetingCheckList> result =smtcdao.create_smtc(smtc);
	    return result;
	  }
	}

