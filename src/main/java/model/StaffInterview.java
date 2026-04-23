package model;

import java.time.LocalDate;

public class StaffInterview {
	  private String client_name_sei;
	  private String client_name_mei;
	  private LocalDate interviewday;
	  private String interview_record;

	  public StaffInterview() {}
	  public StaffInterview(String client_name_sei,String client_name_mei,LocalDate interviewday, String interview_record) {

	    this.client_name_sei = client_name_sei;
	    this.client_name_mei = client_name_mei;
	    this.interviewday = interviewday;
	    this.interview_record = interview_record;
	  }
	  public String getClient_name_sei() {
		  return client_name_sei;
	  }
	  public String getClient_name_mei() {
		  return client_name_mei;
	  }
	  public LocalDate getInterviewday() {
		  return interviewday;
	  }
	  public String getInterview_record() {
		  return interview_record;
	  }
	  public void setClient_name_sei(String client_name_sei) {
		  this.client_name_sei = client_name_sei;
	  }
	  public void setClient_name_mei(String client_name_mei) {
		  this.client_name_mei = client_name_mei;
	  }
	  public void setInterviewday(LocalDate interviewday) {
		  this.interviewday = interviewday;
	  }
	  public void setInterview_record(String interview_record) {
		  this.interview_record = interview_record;
	  }
}
