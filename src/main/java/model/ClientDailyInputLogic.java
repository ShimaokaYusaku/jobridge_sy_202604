package model;

import dao.ClientDailyInputsDAO;

public class ClientDailyInputLogic {

  public boolean execute_cdi(ClientDaily clientdaily, LoginAccount account) { 
	  ClientDailyInputsDAO cdinputdao = new ClientDailyInputsDAO();
	  boolean result =cdinputdao.create_cdi(clientdaily, account);
    return result;
  }
}


