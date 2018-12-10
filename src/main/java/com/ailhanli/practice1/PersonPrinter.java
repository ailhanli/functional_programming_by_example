package com.ailhanli.practice1;

import java.util.List;

public class PersonPrinter {

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}
	
	//task 1: what if we need to print person whose age is between two numbers.
	
	//task 2: how can we solve same problem using Open/Close principle
	
	//task 3: how can we solve same problem using anonymous class
	
	//task 4: easy way lambda
	
	//task 5: what if we need to say function what to do via lambda
	
	//task 6: how can we say to method what to print
}