package model;

import java.io.Serializable;

public class LoginStaffAccount implements Serializable {
	  private int staff_Id;
	  private String staff_name_sei;
	  private String staff_name_mei;
	  private String authority;

	  public LoginStaffAccount() {}
	  public LoginStaffAccount(String staff_name_sei, String staff_name_mei) {
		    this.staff_name_sei = staff_name_sei;
		    this.staff_name_mei = staff_name_mei;
		  }

	  public LoginStaffAccount(int staff_Id, String staff_name_sei, String staff_name_mei, String authority) {
		    this.staff_Id = staff_Id;
		    this.staff_name_sei = staff_name_sei;
		    this.staff_name_mei = staff_name_mei;
		    this.authority = authority;
		  }

	  public int getStaff_Id() { return staff_Id; }
	  public String getstaff_name_sei() { return staff_name_sei; }
	  public String getstaff_name_mei() { return staff_name_mei; }
	  public String getAuthority() { return authority;}
	  
	  public void setStaff_Id(int staff_Id) {
		this.staff_Id = staff_Id;
	  }
	  public void setstaff_name_sei(String staff_name_sei) {
		this.staff_name_sei = staff_name_sei;
	  }
	  public void setstaff_name_mei(String staff_name_mei) {
		this.staff_name_mei = staff_name_mei;
	  }
	  public void setAuthority(String authority) {
		this.authority = authority;
	  }
}
