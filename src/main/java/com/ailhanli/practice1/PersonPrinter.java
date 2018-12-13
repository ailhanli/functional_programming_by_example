package com.ailhanli.practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ailhanli.practice1.Person.Sex;

public class PersonPrinter {

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

//	 task 1: what if we need to print person whose age is between two numbers.
	public static void task1(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (p.getAge() > low && p.getAge() < high) {
				p.printPerson();
			}
		}
	}
	
	

	// task 2: how can we solve same problem using Open/Close principle
	static interface AgeLogic<T> {
		boolean test(T age);
	}
	static class PrintDecider implements AgeLogic<Integer> {

		@Override
		public boolean test(Integer age) {
			boolean canPrint = age > 20 && age < 33;
			return canPrint;
		}

	}
	public static void printPersonsOlderThanV2(List<Person> roster, AgeLogic<Integer> whenToPrint) {
		for (Person p : roster) {
			if (whenToPrint.test(p.getAge())) {
				p.printPerson();
			}
		}
	}
	public static void main(String[] args) {
		// String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		printPersonsOlderThanV2(persons, new PrintDecider());
	}

	
	
	
	// task 3: how can we solve same problem using anonymous class
	public static void main(String[] args) {
		//String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com")
				);
		
		printPersonsOlderThanV2(persons, new AgeLogic<Integer>() {
			@Override
			public boolean test(Integer age) {
				// TODO Auto-generated method stub
				return age>30;
			}
		});
	}

	
	
	
	// task 4: easy way lambda
	public static void main(String[] args) {
		// String name, LocalDate birthDate, Sex gender, String emailAddress
		List<Person> persons = Arrays.asList(
				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));

		
		AgeLogic<Integer> logicImpl = age->age>30;
		printPersonsOlderThanV2(persons, age->age>30 && age<70);
	}
	
	
	
	

	
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
	

	
	

	// task 6: how can we say to method what to print
	
//	public static void printPersonsOlderThanV4(List<Person> roster, Predicate<Integer> whenToPrint, Function<Person, String> whatToPrint, Consumer<String> whatToDo) {
//		for (Person p : roster) {
//			if (whenToPrint.test(p.getAge())) {
//				String emailAddress = whatToPrint.apply(p);
//				whatToDo.accept(emailAddress);
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		// String name, LocalDate birthDate, Sex gender, String emailAddress
//		List<Person> persons = Arrays.asList(
//				new Person("Abdullah", LocalDate.of(1985, 5, 1), Sex.MALE, "abdullah.ilhanli@gmail.com"),
//				new Person("Sinan", LocalDate.of(1987, 7, 1), Sex.MALE, "sinan.tecer@gmail.com"),
//				new Person("Omer", LocalDate.of(1987, 10, 28), Sex.MALE, "omer.ilhanli@gmail.com"));
//
//		printPersonsOlderThanV4(persons, (age)->age>30, p->p.getEmailAddress(), (p)->System.out.println(p));
//	}
}