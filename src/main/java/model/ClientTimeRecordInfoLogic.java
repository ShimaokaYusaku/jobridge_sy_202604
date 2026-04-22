package model;

import java.util.List;

import dao.ClientTimeRecordInfosDAO;

public class ClientTimeRecordInfoLogic {

	  public List<ClientTimeRecordInfoList> execute_ctri(ClientTimeRecordInfo ctri) { 
		  ClientTimeRecordInfosDAO ctridao = new ClientTimeRecordInfosDAO();
		  List<ClientTimeRecordInfoList> result =ctridao.create_ctri(ctri);
	    return result;
	  }
	}

