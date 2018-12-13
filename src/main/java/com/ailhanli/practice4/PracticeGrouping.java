package com.ailhanli.practice4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.javafx.collections.MappingChange.Map;

public class PracticeGrouping {
	
	//practice 4: finding total salary of employee which has same age
	// what if we write it in imperative programming? lets talk!
	public Map<Integer, Double> getSumofEmployeeSalaryByTheirAge(){
		 return null;
	}
	
	public static void main(String[] args) {
	
		List<Employee> employees = Arrays.asList(
				new Employee("employee1", 30, 2000),
				new Employee("employee2", 23, 3000),
				new Employee("employee3", 30, 2000),
				new Employee("employee4", 23, 3000),
				new Employee("employee5", 30, 4000),
				new Employee("employee6", 40, 2000)
				);
				
		employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.summingDouble(Employee::getSalary)));
	}
	
	
}
