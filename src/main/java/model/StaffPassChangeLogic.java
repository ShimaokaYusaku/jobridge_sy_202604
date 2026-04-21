package model;

import dao.StaffPassChangesDAO;

public class StaffPassChangeLogic {
	  public boolean execute_spc(StaffPassChange spc, LoginStaffAccount staffaccount3) {

		  StaffPassChangesDAO dao = new StaffPassChangesDAO();
		    boolean result = dao.change_spc(spc, staffaccount3);
		    return result;

		  }
}
