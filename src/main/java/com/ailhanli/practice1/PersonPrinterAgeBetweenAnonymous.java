package com.ailhanli.practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.ailhanli.practice1.Person.Sex;

public class PersonPrinterAgeBetweenAnonymous {

	// task 3: how can we solve same problem using anonymous class
	public static void main(String[] args) {
		//String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com")
				);
		
		//now we used anonymous inner class. it is one step before functional programming lambda calculus
		PersonPrinterAgeBetweenTwoNumbersV2.printPersonsOlderThanV2(persons, new AgeLogic<Integer>() {
			@Override
			public boolean test(Integer age) {
				return age>30;
			}
		});
	}

}
