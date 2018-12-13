package com.ailhanli.practice5;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.ailhanli.practice1.Person;
import com.ailhanli.practice1.Person.Sex;

public class PracticeMultiThreading {

	
	//task: how can we make a stream parallel
	
	public static void main(String[] args) {
		// String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		persons.parallelStream().filter(p->p.getAge()>30).map(p->p.getEmailAddress()).forEach(e->System.out.println(e));		
	}
}