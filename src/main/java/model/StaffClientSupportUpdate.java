package model;

import java.util.Date;

public class StaffClientSupportUpdate {
	private String name_sei;
	private String name_mei;
	private Date admissionday;
	private Date leavingday;
	private String company;
	private String occupation;
	private String employ_type;
	private Float working_hours;
	private Date  joinday;
	private String offer;
	private String employed;
	private String support_note;
    
	  public StaffClientSupportUpdate() {}
	  public StaffClientSupportUpdate(String name_sei, String name_mei, Date admissionday, Date leavingday, String company, String occupation, String employ_type, Float working_hours, Date joinday, String offer, String employed, String support_note) {
		    this.name_sei = name_sei;
		    this.name_mei = name_mei;
		    this.admissionday = admissionday;
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
	  public String getName_sei() {
		  return name_sei;
	  }

	  public void setName_sei(String name_sei) {
		  this.name_sei = name_sei;
	  }
	  public String getName_mei() {
		  return name_mei;
	  }

	  public Date getAdmissionday() {
		  return admissionday;
	  }
	  public Date getLeavingday() {
		  return leavingday;
	  }
	  public void setLeavingday(Date leavingday) {
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
	  public void setName_mei(String name_mei) {
		  this.name_mei = name_mei;
	  }
	  public void setAdmissionday(Date admissionday) {
		  this.admissionday = admissionday;
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
	  public Date getJoinday() {
		  return joinday;
	  }
	  public void setJoinday(Date joinday) {
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
