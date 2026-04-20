package model;

import java.io.Serializable;
import java.util.Date;

public class LoginAccount implements Serializable {
  private int client_Id;
  private String name_sei;
  private String name_mei;
  private Date expiration_start;

  public LoginAccount() {}
  public LoginAccount(String name_sei, String name_mei) {
	    this.name_sei = name_sei;
	    this.name_mei = name_mei;
	  }
  public LoginAccount(int client_Id, String name_sei, String name_mei) {
    this.client_Id = client_Id;
    this.name_sei = name_sei;
    this.name_mei = name_mei;
  }
  public LoginAccount(int client_Id, String name_sei, String name_mei, Date expiration_start) {
	    this.client_Id = client_Id;
	    this.name_sei = name_sei;
	    this.name_mei = name_mei;
	    this.expiration_start = expiration_start;
	  }

  public int getClient_Id() { return client_Id; }
  public String getName_sei() { return name_sei; }
  public String getName_mei() { return name_mei; }
  public Date getExpiration_start() {
	return expiration_start;
}
  public void setClient_Id(int client_Id) {
	this.client_Id = client_Id;
  }
  public void setName_sei(String name_sei) {
	this.name_sei = name_sei;
  }
  public void setName_mei(String name_mei) {
	this.name_mei = name_mei;
  }
  public void setExpiration_start(Date expiration_start) {
	  this.expiration_start = expiration_start;
  }

  
//  public void setUserId() { this.userId=userId; }
//  public void setname_mei() { this.name_mei=name_mei; }
//  public void sgetMail() { this.mail=mail; }
//  public void setname_sei() { this.name_sei=name_sei; }
//  public void setAge() { this.age=age; }
}