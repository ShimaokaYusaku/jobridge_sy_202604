package model;

import dao.ClientResistersDAO;

public class ClientResisterLogic {

	  public boolean execute_cr(ClientResister cr) { 
		  ClientResistersDAO crdao = new ClientResistersDAO();
		  boolean result =crdao.create_cr(cr);
	    return result;
	  }
	}

