package model;

import java.time.LocalDate;

public class StaffInterviewCheckList {
	  private String staff_name_sei;
	  private String staff_name_mei;
	  private LocalDate interview_day;
	  private String interview_record;
	  

	  public StaffInterviewCheckList() {}
	  public StaffInterviewCheckList(String staff_name_sei, String staff_name_mei, LocalDate interview_day,  String interview_record) {
		this.staff_name_sei = staff_name_sei;
		this.staff_name_mei = staff_name_mei;
	    this.interview_day = interview_day;
	    this.interview_record = interview_record;

	  }
	  public String getStaff_name_sei() {
		  return staff_name_sei;
	  }
	  public String getStaff_name_mei() {
		  return staff_name_mei;
	  }
	  public LocalDate getInterview_day() {
		  return interview_day;
	  }
	  public String getInterview_record() {
		  return interview_record;
	  }
	  public void setStaff_name_sei(String staff_name_sei) {
		  this.staff_name_sei = staff_name_sei;
	  }
	  public void setStaff_name_mei(String staff_name_mei) {
		  this.staff_name_mei = staff_name_mei;
	  }
	  public void setInterview_day(LocalDate interview_day) {
		  this.interview_day = interview_day;
	  }
	  public void setInterview_record(String interview_record) {
		  this.interview_record = interview_record;
	  }
}