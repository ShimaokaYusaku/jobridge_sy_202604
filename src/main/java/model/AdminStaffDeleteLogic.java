package model;

import dao.AdminStaffDeletesDAO;

public class AdminStaffDeleteLogic {

	  public boolean execute_asd(AdminStaffDelete asd) { 
		  AdminStaffDeletesDAO asddao = new AdminStaffDeletesDAO();
		  boolean result =asddao.create_asd(asd);
	    return result;
	  }
	}

