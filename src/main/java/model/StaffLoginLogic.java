package model;

import dao.StaffLoginsDAO;

public class StaffLoginLogic {
	  public StaffAccount execute_staff(StaffLogin staff_login) {

		    StaffLoginsDAO dao = new StaffLoginsDAO();
		    StaffAccount staffaccount = dao.findByLogin_staff(staff_login);
		    return staffaccount;

		  }
}
