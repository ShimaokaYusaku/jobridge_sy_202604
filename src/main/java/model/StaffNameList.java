package model;

import java.io.Serializable;

public class StaffNameList implements Serializable {
	private String staff_name_sei;
	private String staff_name_mei;

	public StaffNameList() {
	}

	public StaffNameList(String staff_name_sei, String staff_name_mei) {
		this.staff_name_sei = staff_name_sei;
		this.staff_name_mei = staff_name_mei;
	}

	public String getStaff_name_sei() {
		return staff_name_sei;
	}

	public String getStaff_name_mei() {
		return staff_name_mei;
	}

	public void setStaff_name_sei(String staff_name_sei) {
		this.staff_name_sei = staff_name_sei;
	}

	public void setStaff_name_mei(String staff_name_mei) {
		this.staff_name_mei = staff_name_mei;
	}
	
}
