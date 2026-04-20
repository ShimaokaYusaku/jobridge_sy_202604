package model;

import dao.ClientPassChangesDAO;

public class ClientPassChangeLogic {
	  public boolean execute_cpc(ClientPassChange cpc, LoginAccount account3) {

		  ClientPassChangesDAO dao = new ClientPassChangesDAO();
		    boolean result = dao.change_cpc(cpc, account3);
		    return result;

		  }
}
