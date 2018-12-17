package com.ailhanli.practice1;

import java.util.List;

public class PersonPrinterBetweenTwoNumbers {

//	 task 1: what if we need to print person whose age is between two numbers.
// 	 now out task1 method age logic changed. So we have to abstract this changes from this method
	public static void task1(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (p.getAge() > low && p.getAge() < high) {
				p.printPerson();
			}
		}
	}
}
