package model;

import dao.StaffClientSupportChecksDAO;

public class StaffClientSupportCheckLogic {

	  public StaffClientSupportUpdate execute_scsc(StaffClientSupportCheck scsc) { 
		  StaffClientSupportChecksDAO scscdao = new StaffClientSupportChecksDAO();
		  StaffClientSupportUpdate result =scscdao.create_scsc(scsc);
	    return result;
	  }
	}

