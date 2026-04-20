package model;

import dao.ClientExpirationUpdatesDAO;

public class ClientExpirationUpdateLogic {
	  public boolean execute_ceu(ClientExpirationUpdate ceu, LoginAccount account3) {

		    ClientExpirationUpdatesDAO dao = new ClientExpirationUpdatesDAO();
		    boolean result = dao.change_ceu(ceu, account3);
		    return result;

		  }
}
