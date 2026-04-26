package model;

public class StaffClientSupport {
	  private String staffClientSupport_name_sei;
	  private String staffClientSupport_name_mei;

	  public StaffClientSupport() {}
	  public StaffClientSupport(String staffClientSupport_name_sei,String staffClientSupport_name_mei) {

	    this.staffClientSupport_name_sei = staffClientSupport_name_sei;
	    this.staffClientSupport_name_mei = staffClientSupport_name_mei;
	  }
	  public String getStaffClientSupport_name_sei() {
		  return staffClientSupport_name_sei;
	  }
	  public void setStaffClientSupport_name_sei(String staffClientSupport_name_sei) {
		  this.staffClientSupport_name_sei = staffClientSupport_name_sei;
	  }
	  public String getStaffClientSupport_name_mei() {
		  return staffClientSupport_name_mei;
	  }
	  public void setStaffClientSupport_name_mei(String staffClientSupport_name_mei) {
		  this.staffClientSupport_name_mei = staffClientSupport_name_mei;
	  }

}
