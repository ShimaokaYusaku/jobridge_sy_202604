package model;

import dao.AdminStaffResistersDAO;

public class AdminStaffResisterLogic {

	  public boolean execute_asr(AdminStaffResister asr) { 
		  AdminStaffResistersDAO asrdao = new AdminStaffResistersDAO();
		  boolean result =asrdao.create_asr(asr);
	    return result;
	  }
	}

