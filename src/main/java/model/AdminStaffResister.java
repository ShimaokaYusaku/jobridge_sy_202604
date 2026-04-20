package model;

public class AdminStaffResister {
	  private String admin_staff_login_name;
	  private String admin_staff_name_sei;
	  private String admin_staff_name_mei;
	  private String admin_staff_name_sei_kana;
	  private String admin_staff_name_mei_kana;
	  private String staff_authority;

	  public AdminStaffResister() {}
	  public AdminStaffResister(String admin_staff_login_name, String admin_staff_name_sei,String admin_staff_name_mei,String admin_staff_name_sei_kana, String admin_staff_name_mei_kana, String staff_authority) {
	    this.admin_staff_login_name = admin_staff_login_name;
	    this.admin_staff_name_sei = admin_staff_name_sei;
	    this.admin_staff_name_mei = admin_staff_name_mei;
	    this.admin_staff_name_sei_kana = admin_staff_name_sei_kana;
	    this.admin_staff_name_mei_kana = admin_staff_name_mei_kana;
	    this.staff_authority = staff_authority;
	  }
	  public String getAdmin_staff_login_name() {
		  return admin_staff_login_name;
	  }
	  public String getAdmin_staff_name_sei() {
		  return admin_staff_name_sei;
	  }
	  public String getAdmin_staff_name_mei() {
		  return admin_staff_name_mei;
	  }
	  public String getAdmin_staff_name_sei_kana() {
		  return admin_staff_name_sei_kana;
	  }
	  public String getAdmin_staff_name_mei_kana() {
		  return admin_staff_name_mei_kana;
	  }
	  public String getStaff_authority() {
		  return staff_authority;
	  }
	  public void setAdmin_staff_login_name(String admin_staff_login_name) {
		  this.admin_staff_login_name = admin_staff_login_name;
	  }
	  public void setAdmin_staff_name_sei(String admin_staff_name_sei) {
		  this.admin_staff_name_sei = admin_staff_name_sei;
	  }
	  public void setAdmin_staff_name_mei(String admin_staff_name_mei) {
		  this.admin_staff_name_mei = admin_staff_name_mei;
	  }
	  public void setAdmin_staff_name_sei_kana(String admin_staff_name_sei_kana) {
		  this.admin_staff_name_sei_kana = admin_staff_name_sei_kana;
	  }
	  public void setAdmin_staff_name_mei_kana(String admin_staff_name_mei_kana) {
		  this.admin_staff_name_mei_kana = admin_staff_name_mei_kana;
	  }
	  public void setStaff_authority(String staff_authority) {
		  this.staff_authority = staff_authority;
	  }
	  


	}