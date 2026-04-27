package model;

import java.io.Serializable;

public class StaffClientSupportCheck implements Serializable {
	  private String staffClientSupportCheck_name_sei;
	  private String staffClientSupportCheck_name_mei;

	  public StaffClientSupportCheck() {}
	  public StaffClientSupportCheck(String staffClientSupportCheck_name_sei,String staffClientSupportCheck_name_mei) {

	    this.staffClientSupportCheck_name_sei = staffClientSupportCheck_name_sei;
	    this.staffClientSupportCheck_name_mei = staffClientSupportCheck_name_mei;
	  }
	  public String getStaffClientSupportCheck_name_sei() {
		  return staffClientSupportCheck_name_sei;
	  }
	  public String getStaffClientSupportCheck_name_mei() {
		  return staffClientSupportCheck_name_mei;
	  }
	  public void setStaffClientSupportCheck_name_sei(String staffClientSupportCheck_name_sei) {
		  this.staffClientSupportCheck_name_sei = staffClientSupportCheck_name_sei;
	  }
	  public void setStaffClientSupportCheck_name_mei(String staffClientSupportCheck_name_mei) {
		  this.staffClientSupportCheck_name_mei = staffClientSupportCheck_name_mei;
	  }


	}