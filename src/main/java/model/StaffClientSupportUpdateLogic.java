package model;

import dao.StaffClientSupportUpdatesDAO;

public class StaffClientSupportUpdateLogic {

	  public boolean  execute_scsu(StaffClientSupportUpdate scsu) { 
		  StaffClientSupportUpdatesDAO scsudao = new StaffClientSupportUpdatesDAO();
		  boolean result =scsudao.update_scsu(scsu);
	    return result;
	  }
	}

