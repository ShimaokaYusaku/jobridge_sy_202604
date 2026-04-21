package model;

import dao.AdminStaffDeletesDAO;

public class AdminStaffDeleteLogic {

	  public boolean execute_asd(AdminStaffDelete asd) { 
		  AdminStaffDeletesDAO asrdao = new AdminStaffDeletesDAO();
		  boolean result =asrdao.create_asd(asd);
	    return result;
	  }
	}

