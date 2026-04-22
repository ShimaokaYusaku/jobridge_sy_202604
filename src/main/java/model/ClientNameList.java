package model;

import java.io.Serializable;

public class ClientNameList implements Serializable {
	private String client_name_sei;
	private String client_name_mei;

	public ClientNameList() {
	}

	public ClientNameList(String client_name_sei, String client_name_mei) {
		this.client_name_sei = client_name_sei;
		this.client_name_mei = client_name_mei;
	}

	public String getClient_name_sei() {
		return client_name_sei;
	}

	public String getClient_name_mei() {
		return client_name_mei;
	}

	public void setClient_name_sei(String client_name_sei) {
		this.client_name_sei = client_name_sei;
	}

	public void setClient_name_mei(String client_name_mei) {
		this.client_name_mei = client_name_mei;
	}
	
}
