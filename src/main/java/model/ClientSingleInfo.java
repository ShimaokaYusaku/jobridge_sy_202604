package model;

public class ClientSingleInfo {
	  private String singleInfo_name_sei;
	  private String singleInfo_name_mei;

	  public ClientSingleInfo() {}
	  public ClientSingleInfo(String singleInfo_name_sei,String singleInfo_name_mei) {

	    this.singleInfo_name_sei = singleInfo_name_sei;
	    this.singleInfo_name_mei = singleInfo_name_mei;
	  }
	  public String getSingleInfo_name_sei() {
		  return singleInfo_name_sei;
	  }
	  public String getSingleInfo_name_mei() {
		  return singleInfo_name_mei;
	  }
	  public void setSingleInfo_name_sei(String singleInfo_name_sei) {
		  this.singleInfo_name_sei = singleInfo_name_sei;
	  }
	  public void setSingleInfo_name_mei(String singleInfo_name_mei) {
		  this.singleInfo_name_mei = singleInfo_name_mei;
	  }


	}