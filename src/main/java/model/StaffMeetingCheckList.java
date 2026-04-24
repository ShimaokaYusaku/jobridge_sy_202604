package model;

import java.time.LocalDate;

public class StaffMeetingCheckList {
	  private String staff_name_sei;
	  private String staff_name_mei;
	  private String staff2_name_sei;
	  private String staff2_name_mei;
	  private String staff3_name_sei;
	  private String staff3_name_mei;
	  private String staff4_name_sei;
	  private String staff4_name_mei;
	  private LocalDate meeting_day;
	  private String meeting_record;
	  

	  public StaffMeetingCheckList() {}
	  public StaffMeetingCheckList(String staff_name_sei, String staff2_name_sei, String staff2_name_mei, String staff3_name_sei, String staff3_name_mei, String staff4_name_sei, String staff4_name_mei, String staff_name_mei, LocalDate meeting_day,  String meeting_record) {
		this.staff_name_sei = staff_name_sei;
		this.staff_name_mei = staff_name_mei;
		this.staff2_name_sei = staff2_name_sei;
		this.staff2_name_sei = staff2_name_mei;
		this.staff3_name_sei = staff3_name_sei;
		this.staff3_name_sei = staff3_name_mei;
		this.staff4_name_sei = staff4_name_sei;
		this.staff4_name_sei = staff4_name_mei;
	    this.meeting_day = meeting_day;
	    this.meeting_record = meeting_record;

	  }
	  public String getStaff_name_sei() {
		  return staff_name_sei;
	  }
	  public String getStaff_name_mei() {
		  return staff_name_mei;
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
	  public LocalDate getMeeting_day() {
		  return meeting_day;
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
	  public void setStaff_name_sei(String staff_name_sei) {
		  this.staff_name_sei = staff_name_sei;
	  }
	  public void setStaff_name_mei(String staff_name_mei) {
		  this.staff_name_mei = staff_name_mei;
	  }

	  public void setMeeting_day(LocalDate meeting_day) {
		  this.meeting_day = meeting_day;
	  }
	  public void setMeeting_record(String meeting_record) {
		  this.meeting_record = meeting_record;
	  }
}