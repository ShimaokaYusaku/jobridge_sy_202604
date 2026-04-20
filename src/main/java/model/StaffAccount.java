package model;

public class StaffAccount {
	  private String staff_login_name;
	  private String staff_pass;

public StaffAccount() {}
public StaffAccount(String staff_login_name, String staff_pass) {
	    this.staff_login_name = staff_login_name;
	    this.staff_pass = staff_pass;
}
public String getstaff_login_name() { return staff_login_name; }
public String getstaff_pass() { return staff_pass; }
}
