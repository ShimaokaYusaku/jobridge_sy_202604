package model;

import java.io.Serializable;
import java.time.LocalDate;

public class ClientDisabilityList implements Serializable {
	private String client_name_sei;
	private String client_name_mei;
	private String disability;
	private LocalDate expiration_day;
	private String disability_type;
	private String disability_grade;

	public ClientDisabilityList() {	}

	public ClientDisabilityList(String client_name_sei, String client_name_mei, String disability, LocalDate expiration_day, String disability_type, String disability_grade) {
		this.client_name_sei = client_name_sei;
		this.client_name_mei = client_name_mei;
		this.disability = disability;
		this.expiration_day = expiration_day;
		this.disability_type = disability_type;
		this.disability_grade = disability_grade;
	}

	public String getClient_name_sei() {
		return client_name_sei;
	}

	public String getClient_name_mei() {
		return client_name_mei;
	}

	public String getDisability() {
		return disability;
	}

	public LocalDate getExpiration_day() {
		return expiration_day;
	}

	public String getDisability_type() {
		return disability_type;
	}

	public String getDisability_grade() {
		return disability_grade;
	}

	public void setClient_name_sei(String client_name_sei) {
		this.client_name_sei = client_name_sei;
	}

	public void setClient_name_mei(String client_name_mei) {
		this.client_name_mei = client_name_mei;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public void setExpiration_day(LocalDate expiration_day) {
		this.expiration_day = expiration_day;
	}

	public void setDisability_type(String disability_type) {
		this.disability_type = disability_type;
	}

	public void setDisability_grade(String disability_grade) {
		this.disability_grade = disability_grade;
	}


	
}
