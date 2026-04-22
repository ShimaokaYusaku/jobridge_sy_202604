package model;

import java.time.LocalDate;

public class ClientTimeRecordInfoList {
	  private LocalDate work_day;
	  private String start_time;
	  private String end_time;
	  

	  public ClientTimeRecordInfoList() {}
	  public ClientTimeRecordInfoList(LocalDate work_day, String start_time, String end_time) {
	    this.work_day = work_day;
	    this.start_time = start_time;
	    this.end_time = end_time;

	  }
	  public LocalDate getWork_day() {
		  return work_day;
	  }
	  public String getStart_time() {
		  return start_time;
	  }
	  public String getEnd_time() {
		  return end_time;
	  }
	  public void setWork_day(LocalDate work_day) {
		  this.work_day = work_day;
	  }
	  public void setStart_time(String start_time) {
		  this.start_time = start_time;
	  }
	  public void setEnd_time(String end_time) {
		  this.end_time = end_time;
	  }
}