package model;

import java.time.LocalDate;

public class StaffClientSupportUpdate {
	private LocalDate leavingday;
	private String company;
	private String occupation;
	private String employ_type;
	private Float working_hours;
	private LocalDate  joinday;
	private String offer;
	private String employed;
	private String support_note;
    
	  public StaffClientSupportUpdate() {}
	  public StaffClientSupportUpdate(LocalDate leavingday, String company, String occupation, String employ_type, Float working_hours, LocalDate joinday, String offer, String employed, String support_note) {
		    this.leavingday = leavingday;
		    this.company = company;
		    this.occupation = occupation;
		    this.employ_type= employ_type;
		    this.working_hours = working_hours;
		    this.joinday = joinday;
		    this.offer = offer;
		    this.employed = employed;
		    this.support_note = support_note;
	  }
	  public LocalDate getLeavingday() {
		  return leavingday;
	  }
	  public void setLeavingday(LocalDate leavingday) {
		  this.leavingday = leavingday;
	  }
	  public String getCompany() {
		  return company;
	  }
	  public void setCompany(String company) {
		  this.company = company;
	  }
	  public String getOccupation() {
		  return occupation;
	  }
	  public void setOccupation(String occupation) {
		  this.occupation = occupation;
	  }
	  public String getEmploy_type() {
		  return employ_type;
	  }
	  public void setEmploy_type(String employ_type) {
		  this.employ_type = employ_type;
	  }
	  public Float getWorking_hours() {
		  return working_hours;
	  }
	  public void setWorking_hours(Float working_hours) {
		  this.working_hours = working_hours;
	  }
	  public LocalDate getJoinday() {
		  return joinday;
	  }
	  public void setJoinday(LocalDate joinday) {
		  this.joinday = joinday;
	  }
	  public String getOffer() {
		  return offer;
	  }
	  public void setOffer(String offer) {
		  this.offer = offer;
	  }
	  public String getEmployed() {
		  return employed;
	  }
	  public void setEmployed(String employed) {
		  this.employed = employed;
	  }
	  public String getSupport_note() {
		  return support_note;
	  }
	  public void setSupport_note(String support_note) {
		  this.support_note = support_note;
	  }
	  
}
