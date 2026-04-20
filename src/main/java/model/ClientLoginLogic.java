package model;

import dao.ClientLoginsDAO;

public class ClientLoginLogic {
  public Account execute(ClientLogin login) {

    ClientLoginsDAO dao = new ClientLoginsDAO();
    Account account = dao.findByLogin(login);
    return account;

  }
}