package model;

public class ClientLogin {
  private String client_login_name;
  private String client_pass;
  
  public ClientLogin() {}
  
  public ClientLogin(String client_login_name) {
	    this.client_login_name = client_login_name;
	  }
  
  public ClientLogin(String client_login_name, String client_pass) {
    this.client_login_name = client_login_name;
    this.client_pass = client_pass;
  }
  

  public String getClient_login_name() { return client_login_name; }
  public String getClient_pass() { return client_pass; }

}