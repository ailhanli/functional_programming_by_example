package com.ailhanli.practice1;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	private String name;
	private LocalDate birthDate;
	private Sex gender;
	private String emailAddress;

	
	
	public Person(String name, LocalDate birthDate, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void printPerson() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", emailAddress="
				+ emailAddress + "]";
	}

}