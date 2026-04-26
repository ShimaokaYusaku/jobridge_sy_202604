package model;

import java.io.Serializable;
import java.util.Date;

public class SupportAccount implements Serializable {
	  private int client_Id;
	  private String name_sei;
	  private String name_mei;
	  private Date admissionday;

	  public SupportAccount() {}

	  public SupportAccount(int client_Id, String name_sei, String name_mei, Date admissionday) {
		    this.client_Id = client_Id;
		    this.name_sei = name_sei;
		    this.name_mei = name_mei;
		    this.admissionday = admissionday;
		  }

	  public int getClient_Id() {
		  return client_Id;
	  }

	  public void setClient_Id(int client_Id) {
		  this.client_Id = client_Id;
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

	  public void setName_mei(String name_mei) {
		  this.name_mei = name_mei;
	  }

	  public Date getAdmissionday() {
		  return admissionday;
	  }

	  public void setAdmissionday(Date admissionday) {
		  this.admissionday = admissionday;
	  }
}
