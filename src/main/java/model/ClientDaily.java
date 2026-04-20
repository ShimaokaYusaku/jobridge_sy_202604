package model;

import java.time.LocalTime;

public class ClientDaily {
  private LocalTime start_time;
  private LocalTime end_time;
  private String condition;
  private String work_record;
  private String impression;

  public ClientDaily() {}
  public ClientDaily(LocalTime start_time, LocalTime end_time,String condition, String work_record, String impression) {
    this.start_time = start_time;
    this.end_time = end_time;
    this.condition = condition;
    this.work_record = work_record;
    this.impression = impression;
  }
  
  public LocalTime getStart_time() {
	return start_time;
}
  public void setStart_time(LocalTime start_time) {
	this.start_time = start_time;
  }
  public LocalTime getEnd_time() {
	return end_time;
  }
  public void setEnd_time(LocalTime end_time) {
	this.end_time = end_time;
  }
  public String getCondition() {
	return condition;
  }
  public void setCondition(String condition) {
	this.condition = condition;
  }
  public String getWork_record() {
	return work_record;
  }
  public void setWork_record(String work_record) {
	this.work_record = work_record;
  }
  public String getImpression() {
	return impression;
  }
  public void setImpression(String impression) {
	this.impression = impression;
  }

}


//String start_time = request.getParameter("start_time");
//String end_time = request.getParameter("end_time");
//String condition = request.getParameter("condition");
//String work_record = request.getParameter("work_record");
//String impression = request.getParameter("impression");