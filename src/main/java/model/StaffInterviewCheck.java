package model;

import java.io.Serializable;

public class StaffInterviewCheck implements Serializable {
	  private String staffInterviewCheck_name_sei;
	  private String staffInterviewCheck_name_mei;

	  public StaffInterviewCheck() {}
	  public StaffInterviewCheck(String staffInterviewCheck_name_sei,String staffInterviewCheck_name_mei) {

	    this.staffInterviewCheck_name_sei = staffInterviewCheck_name_sei;
	    this.staffInterviewCheck_name_mei = staffInterviewCheck_name_mei;
	  }
	  public String getStaffInterviewCheck_name_sei() {
		  return staffInterviewCheck_name_sei;
	  }
	  public String getStaffInterviewCheck_name_mei() {
		  return staffInterviewCheck_name_mei;
	  }
	  public void setStaffInterviewCheck_name_sei(String staffInterviewCheck_name_sei) {
		  this.staffInterviewCheck_name_sei = staffInterviewCheck_name_sei;
	  }
	  public void setStaffInterviewCheck_name_mei(String staffInterviewCheck_name_mei) {
		  this.staffInterviewCheck_name_mei = staffInterviewCheck_name_mei;
	  }


	}