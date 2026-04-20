package model;

import dao.ClientMenusDAO;


public class ClientMenuLogic {
	  public LoginAccount execute(ClientLogin login) {

		    ClientMenusDAO dao = new ClientMenusDAO();
		    LoginAccount account3 = dao.findLoginInfo(login);
		    return account3;

		  }
}
