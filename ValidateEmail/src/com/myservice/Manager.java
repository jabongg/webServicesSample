package com.myservice;

public class Manager {
	
	public Manager(String name, int age, String company) {
		this.name 	= name;
		this.age 	= age;
		this.company= company;
	}
	
	private String name;
	private int age;
	private String company;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
