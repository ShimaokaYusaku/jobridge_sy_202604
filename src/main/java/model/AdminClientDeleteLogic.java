package model;

import dao.AdminClientDeletesDAO;

public class AdminClientDeleteLogic {

	  public boolean execute_acd(AdminClientDelete acd) { 
		  AdminClientDeletesDAO acddao = new AdminClientDeletesDAO();
		  boolean result =acddao.create_acd(acd);
	    return result;
	  }
	}

