package com.model;

public class Trainee {
	private int id;
	private String name;
	private double salary;
	private long contact;
	private String gender;
	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", contact=" + contact + ", gender=" + gender + "]";
	}
	
}
