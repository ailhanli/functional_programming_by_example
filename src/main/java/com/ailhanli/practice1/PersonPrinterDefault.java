package com.ailhanli.practice1;

import java.util.List;

public class PersonPrinterDefault {

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}
}