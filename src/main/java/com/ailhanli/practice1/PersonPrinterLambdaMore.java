package com.ailhanli.practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ailhanli.practice1.Person.Sex;

public class PersonPrinterLambdaMore {
	
	    // task 5: what if we need to say function what to do via lambda
		//we dont need our custom interface there is already built-in functional interface Predicate
		public static void printPersonsOlderThanV3(List<Person> roster, Predicate<Integer> whenToPrint, Function<Person, String> whatToPrint) {
			for (Person p : roster) {
				if (whenToPrint.test(p.getAge())) {
					String emailAddress = whatToPrint.apply(p);
					System.out.println(emailAddress);
				}
			}
		}
		
		public static void main(String[] args) {
			// String name, LocalDate birthDate, Sex gender, String emailAddress
			List<Person> persons = Arrays.asList(
					new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
					new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
					new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

			printPersonsOlderThanV3(persons, (age)->age>30, p->p.getEmailAddress());
		}
}