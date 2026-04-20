package model;

public class Account {
	  private String client_login_name;
	  private String client_pass;

  public Account() {}
  public Account(String client_login_name, String client_pass) {
	    this.client_login_name = client_login_name;
	    this.client_pass = client_pass;
  }
  public String getclient_login_name() { return client_login_name; }
  public String getclient_pass() { return client_pass; }
  
}