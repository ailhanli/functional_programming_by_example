package com.ailhanli.practice3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ailhanli.practice1.Person;
import com.ailhanli.practice1.Person.Sex;

public class PracticeStreamApi {

	public static void printPerson(List<Person> roster, Predicate<Integer> whenToPrint,
			Function<Person, String> whatToPrint, Consumer<String> whatToDo) {
		for (Person p : roster) {
			if (whenToPrint.test(p.getAge())) {
				String emailAddress = whatToPrint.apply(p);
				whatToDo.accept(emailAddress);
			}
		}
	}

	public static void main(String[] args) {
		// String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		printPerson(persons, (age) -> age > 30, p -> p.getEmailAddress(), (p) -> System.out.println(p));
		
	}
	
	//task: write printPerson with Stream API
	public static void main(String[] args) {
		// String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		persons.stream().filter(p->p.getAge()>30).map(Person::getEmailAddress).forEach(e->System.out.println(e));
		
	}

}
