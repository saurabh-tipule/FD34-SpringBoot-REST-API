package com.cjc.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Laptop {

	@Id
	private int lid;

	private String lapName;

	private String color;

	private double price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Employee_Id")
	private Employee emp;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLapName() {
		return lapName;
	}

	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
