package model;

public class StaffLogin {
	  private String staff_login_name;
	  private String staff_pass;
	  
	  public StaffLogin() {}
	  
	  public StaffLogin(String staff_login_name) {
		    this.staff_login_name = staff_login_name;
		  }
	  
	  public StaffLogin(String staff_login_name, String staff_pass) {
	    this.staff_login_name = staff_login_name;
	    this.staff_pass = staff_pass;
	  }
	  

	  public String getStaff_login_name() { return staff_login_name; }
	  public String getStaff_pass() { return staff_pass; }
}
