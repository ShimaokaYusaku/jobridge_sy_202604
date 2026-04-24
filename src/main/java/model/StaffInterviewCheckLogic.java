package model;

import java.util.List;

import dao.StaffInterviewChecksDAO;

public class StaffInterviewCheckLogic {

	  public List<StaffInterviewCheckList> execute_sivc(StaffInterviewCheck sivc) { 
		  StaffInterviewChecksDAO sivcdao = new StaffInterviewChecksDAO();
		  List<StaffInterviewCheckList> result =sivcdao.create_sivc(sivc);
	    return result;
	  }
	}

