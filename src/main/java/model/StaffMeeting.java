package model;

import java.time.LocalDate;

public class StaffMeeting {
	  private String staff2_name_sei;
	  private String staff2_name_mei;
	  private String staff3_name_sei;
	  private String staff3_name_mei;
	  private String staff4_name_sei;
	  private String staff4_name_mei;
	  private LocalDate meetingday;
	  private String meeting_record;

	  public StaffMeeting() {}
	  public StaffMeeting(String staff2_name_sei,String staff2_name_mei,String staff3_name_sei,String staff3_name_mei,String staff4_name_sei,String staff4_name_mei,LocalDate meetingday, String meeting_record) {

	    this.staff2_name_sei = staff2_name_sei;
	    this.staff2_name_mei = staff2_name_mei;
	    this.staff3_name_sei = staff3_name_sei;
	    this.staff3_name_mei = staff3_name_mei;
	    this.staff4_name_sei = staff4_name_sei;
	    this.staff4_name_mei = staff4_name_mei;
	    this.meetingday = meetingday;
	    this.meeting_record = meeting_record;
	  }
	  public String getStaff2_name_sei() {
		  return staff2_name_sei;
	  }
	  public String getStaff2_name_mei() {
		  return staff2_name_mei;
	  }
	  public String getStaff3_name_sei() {
		  return staff3_name_sei;
	  }
	  public String getStaff3_name_mei() {
		  return staff3_name_mei;
	  }
	  public String getStaff4_name_sei() {
		  return staff4_name_sei;
	  }
	  public String getStaff4_name_mei() {
		  return staff4_name_mei;
	  }
	  public LocalDate getMeetingday() {
		  return meetingday;
	  }
	  public String getMeeting_record() {
		  return meeting_record;
	  }
	  public void setStaff2_name_sei(String staff2_name_sei) {
		  this.staff2_name_sei = staff2_name_sei;
	  }
	  public void setStaff2_name_mei(String staff2_name_mei) {
		  this.staff2_name_mei = staff2_name_mei;
	  }
	  public void setStaff3_name_sei(String staff3_name_sei) {
		  this.staff3_name_sei = staff3_name_sei;
	  }
	  public void setStaff3_name_mei(String staff3_name_mei) {
		  this.staff3_name_mei = staff3_name_mei;
	  }
	  public void setStaff4_name_sei(String staff4_name_sei) {
		  this.staff4_name_sei = staff4_name_sei;
	  }
	  public void setStaff4_name_mei(String staff4_name_mei) {
		  this.staff4_name_mei = staff4_name_mei;
	  }
	  public void setMeetingday(LocalDate meetingday) {
		  this.meetingday = meetingday;
	  }
	  public void setMeeting_record(String meeting_record) {
		  this.meeting_record = meeting_record;
	  }
}