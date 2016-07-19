package com.cn.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mobile implements Serializable{
	private Integer id;
	private String phonenumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", phonenumber=" + phonenumber + "]";
	}
	
	
}
