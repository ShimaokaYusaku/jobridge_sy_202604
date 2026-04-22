package model;

import java.time.LocalDate;

public class ClientSingleInfoList {
	  private String client_login_name;
	  private String client_name_sei;
	  private String client_name_mei;
	  private String client_name_sei_kana;
	  private String client_name_mei_kana;
	  private LocalDate birthday;
	  private String gender;
	  private String address;
	  private String phone;
	  private String emergency_name;
	  private String emergency_rel;
	  private String emergency_phone;
	  private String disability;
	  private LocalDate expiration_start;
	  private String hospital;
	  private String doctor;
	  private String disability_type;
	  private String disability_grade;
	  private String station;
	  private String expenses;
	  private String route;
	  

	  public ClientSingleInfoList() {}
	  public ClientSingleInfoList(String client_login_name, String client_name_sei,String client_name_mei,String client_name_sei_kana, String client_name_mei_kana, LocalDate birthday, String gender, String address, String phone, String emergency_name, String emergency_rel, String emergency_phone, String disability, LocalDate expiration_start, String hospital, String doctor, String disability_type, String disability_grade, String station, String expenses, String route) {
	    this.client_login_name = client_login_name;
	    this.client_name_sei = client_name_sei;
	    this.client_name_mei = client_name_mei;
	    this.client_name_sei_kana = client_name_sei_kana;
	    this.client_name_mei_kana = client_name_mei_kana;
	    this.birthday = birthday;
	    this.gender = gender;
	    this.address = address;
	    this.phone = phone;
	    this.emergency_name = emergency_name;
	    this.emergency_rel = emergency_rel;
	    this.emergency_phone = emergency_phone;
	    this.disability= disability;
	    this.expiration_start = expiration_start;
	    this.hospital = hospital;
	    this.doctor = doctor;
	    this.disability_type = disability_type;
	    this.disability_grade = disability_grade;
	    this.station = station;
	    this.expenses = expenses;
	    this.route = route;
	  }
	  public String getClient_login_name() {
		  return client_login_name;
	  }
	  public String getClient_name_sei() {
		  return client_name_sei;
	  }
	  public String getClient_name_mei() {
		  return client_name_mei;
	  }
	  public String getClient_name_sei_kana() {
		  return client_name_sei_kana;
	  }
	  public String getClient_name_mei_kana() {
		  return client_name_mei_kana;
	  }
	  public LocalDate getBirthday() {
		  return birthday;
	  }
	  public String getGender() {
		  return gender;
	  }
	  public String getAddress() {
		  return address;
	  }
	  public String getPhone() {
		  return phone;
	  }
	  public String getEmergency_name() {
		  return emergency_name;
	  }
	  public String getEmergency_rel() {
		  return emergency_rel;
	  }
	  public String getEmergency_phone() {
		  return emergency_phone;
	  }
	  public String getDisability() {
		  return disability;
	  }
	  public LocalDate getExpiration_start() {
		  return expiration_start;
	  }
	  public String getHospital() {
		  return hospital;
	  }
	  public String getDoctor() {
		  return doctor;
	  }
	  public String getDisability_type() {
		  return disability_type;
	  }
	  public String getDisability_grade() {
		  return disability_grade;
	  }
	  public String getStation() {
		  return station;
	  }
	  public String getExpenses() {
		  return expenses;
	  }
	  public String getRoute() {
		  return route;
	  }
	  public void setClient_login_name(String client_login_name) {
		  this.client_login_name = client_login_name;
	  }
	  public void setClient_name_sei(String client_name_sei) {
		  this.client_name_sei = client_name_sei;
	  }
	  public void setClient_name_mei(String client_name_mei) {
		  this.client_name_mei = client_name_mei;
	  }
	  public void setClient_name_sei_kana(String client_name_sei_kana) {
		  this.client_name_sei_kana = client_name_sei_kana;
	  }
	  public void setClient_name_mei_kana(String client_name_mei_kana) {
		  this.client_name_mei_kana = client_name_mei_kana;
	  }
	  public void setBirthday(LocalDate birthday) {
		  this.birthday = birthday;
	  }
	  public void setGender(String gender) {
		  this.gender = gender;
	  }
	  public void setAddress(String address) {
		  this.address = address;
	  }
	  public void setPhone(String phone) {
		  this.phone = phone;
	  }
	  public void setEmergency_name(String emergency_name) {
		  this.emergency_name = emergency_name;
	  }
	  public void setEmergency_rel(String emergency_rel) {
		  this.emergency_rel = emergency_rel;
	  }
	  public void setEmergency_phone(String emergency_phone) {
		  this.emergency_phone = emergency_phone;
	  }
	  public void setDisability(String disability) {
		  this.disability = disability;
	  }
	  public void setExpiration_start(LocalDate expiration_start) {
		  this.expiration_start = expiration_start;
	  }
	  public void setHospital(String hospital) {
		  this.hospital = hospital;
	  }
	  public void setDoctor(String doctor) {
		  this.doctor = doctor;
	  }
	  public void setDisability_type(String disability_type) {
		  this.disability_type = disability_type;
	  }
	  public void setDisability_grade(String disability_grade) {
		  this.disability_grade = disability_grade;
	  }
	  public void setStation(String station) {
		  this.station = station;
	  }
	  public void setExpenses(String expenses) {
		  this.expenses = expenses;
	  }
	  public void setRoute(String route) {
		  this.route = route;
	  }



	}