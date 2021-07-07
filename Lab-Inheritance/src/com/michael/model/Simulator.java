package com.michael.model;

public class Simulator {
	public static void main(String[] args) {
		FlyingVehicle fv = new FlyingVehicle((short)4, new Engine());
		
		fv.setName("a new flying vehicle");
		System.out.println(fv.getName());
		
		Airplane boeing = new Airplane((short)4, (short)5);
		boeing.move(15);
	}
}
