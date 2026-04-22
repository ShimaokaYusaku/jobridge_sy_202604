package model;

import java.io.Serializable;

public class ClientTimeRecordInfo implements Serializable {
	  private String timeRecordInfo_name_sei;
	  private String timeRecordInfo_name_mei;

	  public ClientTimeRecordInfo() {}
	  public ClientTimeRecordInfo(String timeRecordInfo_name_sei,String timeRecordInfo_name_mei) {

	    this.timeRecordInfo_name_sei = timeRecordInfo_name_sei;
	    this.timeRecordInfo_name_mei = timeRecordInfo_name_mei;
	  }
	  public String getTimeRecordInfo_name_sei() {
		  return timeRecordInfo_name_sei;
	  }
	  public String getTimeRecordInfo_name_mei() {
		  return timeRecordInfo_name_mei;
	  }
	  public void setTimeRecordInfo_name_sei(String timeRecordInfo_name_sei) {
		  this.timeRecordInfo_name_sei = timeRecordInfo_name_sei;
	  }
	  public void setTimeRecordInfo_name_mei(String timeRecordInfo_name_mei) {
		  this.timeRecordInfo_name_mei = timeRecordInfo_name_mei;
	  }


	}