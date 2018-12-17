package com.ailhanli.practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.ailhanli.practice1.Person.Sex;

interface AgeLogic<T> {
	boolean test(T age);
}

 class PrintDecider implements AgeLogic<Integer> {

	@Override
	public boolean test(Integer age) {
		boolean canPrint = age > 20 && age < 33;
		return canPrint;
	}

}

public class PersonPrinterAgeBetweenTwoNumbersV2 {

	// task 2: how separate age logic from method. So we used Open/Close principle
	

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

}
