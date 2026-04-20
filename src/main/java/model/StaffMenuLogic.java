package model;

import dao.StaffMenusDAO;

public class StaffMenuLogic {
	  public LoginStaffAccount execute_staff(StaffLogin login) {

		    StaffMenusDAO dao = new StaffMenusDAO();
		    LoginStaffAccount staffaccount3 = dao.findLoginInfo_staff(login);
		    return staffaccount3;

		  }
}
