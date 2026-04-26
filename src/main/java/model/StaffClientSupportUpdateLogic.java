package model;

import dao.StaffClientSupportUpdatesDAO;

public class StaffClientSupportUpdateLogic {

	  public boolean execute_scsu(StaffClientSupport scs) { 
		  StaffClientSupportUpdatesDAO scsudao = new StaffClientSupportUpdatesDAO();
		  boolean  result =scsudao.create_scsu(scsu);
	    return result;
	  }
	}

