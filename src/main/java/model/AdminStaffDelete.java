package model;

public class AdminStaffDelete {
	  private String delete_admin_staff_name_sei;
	  private String delete_admin_staff_name_mei;

	  public AdminStaffDelete() {}
	  public AdminStaffDelete(String delete_admin_staff_name_sei,String delete_admin_staff_name_mei) {

	    this.delete_admin_staff_name_sei = delete_admin_staff_name_sei;
	    this.delete_admin_staff_name_mei = delete_admin_staff_name_mei;
	  }
	  public String getDelete_admin_staff_name_sei() {
		  return delete_admin_staff_name_sei;
	  }
	  public String getDelete_admin_staff_name_mei() {
		  return delete_admin_staff_name_mei;
	  }
	  public void setDelete_admin_staff_name_sei(String delete_admin_staff_name_sei) {
		  this.delete_admin_staff_name_sei = delete_admin_staff_name_sei;
	  }
	  public void setDelete_admin_staff_name_mei(String delete_admin_staff_name_mei) {
		  this.delete_admin_staff_name_mei = delete_admin_staff_name_mei;
	  }

	}