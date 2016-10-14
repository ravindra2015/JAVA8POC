package com.santosh;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfo {

	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
			    new Employee("Alice M", "Albert",104800),
			    new Employee("Thomas T", "Duarte",111100),
			    new Employee("Cory S","Gonsalves",116100),
			    new Employee("Susan E","Evans",107200),
			    new Employee("Samantha J","Peralta",116600),
			    new Employee("Marilyn A","Williams",93100),
			    new Employee("Jackeline C","Abeyta",100900),
			    new Employee("Juan T", "Young",106900),
			    new Employee("Barbara J","Brown",114500),
			    new Employee("Joseph C","Allred",114600));
		
		//Method reference using object instance for instance method
		empList.stream()
	    .filter(e -> e.getSalary() > 100000)
	    .map(e -> e.getFirstName())
	            // Lambda Expression to map Employee to String (Employee Name)
	    .collect(Collectors.toList());
		System.out.println("lllllllllllllllll");
	 //   .forEach(e -> System.out.println(e));
	    
       //Method reference using Classname for instance method
		empList.stream()
	    .filter(e -> e.getSalary() > 100000)
	    .map(Employee::getFirstName)
	            // Instance Method Reference to map Employee to String (Employee Name)
	    .forEach(e -> System.out.println(e));
		
		empList.stream() //Open a stream on List
	    .filter(e -> e.getSalary() > 100000)  //Find employees with Salary Higher than 100k
	    .sorted((Employee e1, Employee e2) -> e1.getSalary()- e2.getSalary()) //Sort Employee from highest to lowest Salary
	    .forEach(e -> System.out.println("Name : " + e.getFirstName()+", Salary : " + e.getSalary())); //Print Employees in sorted order
		
	}

}
