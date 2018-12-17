package com.ailhanli.practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ailhanli.practice1.Person.Sex;

public class PersonPrinterLambdaFinal {


	// task 6: how can we say to method what to print. now every logic passed as lambda. we are more functional than before. this is strategy pattern.
	
	public static void printPersonsOlderThanV4(List<Person> roster, 
			Predicate<Integer> whenToPrint, Function<Person, String> whatToPrint, 
			Consumer<String> whatToDo) {
		for (Person p : roster) {
			if (whenToPrint.test(p.getAge())) {
				String emailAddress = whatToPrint.apply(p);
				whatToDo.accept(emailAddress);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		printPersonsOlderThanV4(persons, (age)->age>30, p->p.getEmailAddress(), (p)->System.out.println(p));
	}
}