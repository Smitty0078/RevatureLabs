package com.example.test;

import com.example.Developer;
import com.example.Person;

public class TestPerson {

	public static void main(String[] args) {
		//cant instantiate an abstract class
		Person adam = new Developer();
		
		adam.setName("adam");
		System.out.println(adam.getName());
	}
}
