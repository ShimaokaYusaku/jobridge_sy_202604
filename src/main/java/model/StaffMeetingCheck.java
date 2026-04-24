package model;

import java.io.Serializable;

public class StaffMeetingCheck implements Serializable {
	  private String staffMeetingCheck_name_sei;
	  private String staffMeetingCheck_name_mei;

	  public StaffMeetingCheck() {}
	  public StaffMeetingCheck(String staffMeetingCheck_name_sei,String staffMeetingCheck_name_mei) {

	    this.staffMeetingCheck_name_sei = staffMeetingCheck_name_sei;
	    this.staffMeetingCheck_name_mei = staffMeetingCheck_name_mei;
	  }
	  public String getStaffMeetingCheck_name_sei() {
		  return staffMeetingCheck_name_sei;
	  }
	  public String getStaffMeetingCheck_name_mei() {
		  return staffMeetingCheck_name_mei;
	  }
	  public void setStaffMeetingCheck_name_sei(String staffMeetingCheck_name_sei) {
		  this.staffMeetingCheck_name_sei = staffMeetingCheck_name_sei;
	  }
	  public void setStaffMeetingCheck_name_mei(String staffMeetingCheck_name_mei) {
		  this.staffMeetingCheck_name_mei = staffMeetingCheck_name_mei;
	  }


	}