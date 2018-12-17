package com.ailhanli.practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.ailhanli.practice1.Person.Sex;

public class PersonPrinterAgeBetweenLambda {

	// task 4: easy way lambda.  with lambda syntax is shorthand.
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		
		AgeLogic<Integer> logicImpl = age->age>30;
		PersonPrinterAgeBetweenTwoNumbersV2.printPersonsOlderThanV2(persons, logicImpl);
	}	
}