package com.michael.model;

public class Vehicle {

	private String name;
	private long serialNumber;
	
	//getter for name
	public String getName() {
		return this.name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	//getter for serial number
	public long getSerialNumber() {
		return this.serialNumber;
	}
	//setter for serial number
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void move(int spaces)
	{
		System.out.println("Vehicle moved " + spaces + " spaces.");
	}
	
	
}
