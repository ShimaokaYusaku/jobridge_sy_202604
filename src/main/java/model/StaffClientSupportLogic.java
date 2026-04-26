package model;

import dao.StaffClientSupportsDAO;

public class StaffClientSupportLogic {

	  public boolean execute_scs(SupportAccount supportaccount4, StaffClientSupportInput scsi) { 
		  StaffClientSupportsDAO scsdao = new StaffClientSupportsDAO();
		  boolean  result =scsdao.create_scs(supportaccount4, scsi);
	    return result;
	  }
	}

