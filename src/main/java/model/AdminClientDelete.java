package model;

public class AdminClientDelete {
	  private String delete_admin_client_name_sei;
	  private String delete_admin_client_name_mei;

	  public AdminClientDelete() {}
	  public AdminClientDelete(String delete_admin_client_name_sei,String delete_admin_client_name_mei) {

	    this.delete_admin_client_name_sei = delete_admin_client_name_sei;
	    this.delete_admin_client_name_mei = delete_admin_client_name_mei;
	  }
	  public String getDelete_admin_client_name_sei() {
		  return delete_admin_client_name_sei;
	  }
	  public String getDelete_admin_client_name_mei() {
		  return delete_admin_client_name_mei;
	  }
	  public void setDelete_admin_client_name_sei(String delete_admin_client_name_sei) {
		  this.delete_admin_client_name_sei = delete_admin_client_name_sei;
	  }
	  public void setDelete_admin_client_name_mei(String delete_admin_client_name_mei) {
		  this.delete_admin_client_name_mei = delete_admin_client_name_mei;
	  }

	}