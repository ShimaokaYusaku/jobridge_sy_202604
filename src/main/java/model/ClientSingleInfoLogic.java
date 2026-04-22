package model;

import dao.ClientSingleInfosDAO;

public class ClientSingleInfoLogic {

	  public ClientSingleInfoList execute_csi(ClientSingleInfo csi) { 
		  ClientSingleInfosDAO csidao = new ClientSingleInfosDAO();
		  ClientSingleInfoList result =csidao.create_csi(csi);
	    return result;
	  }
	}

