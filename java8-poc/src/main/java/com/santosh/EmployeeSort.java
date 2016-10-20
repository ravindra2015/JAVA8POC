package com.santosh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort {
	private static List<Employee> getEmployees(){
	    List<Employee> employees  = new ArrayList<>();
	    employees.add(new Employee("Lokesh", "Gupta", 32000));
	    employees.add(new Employee("Aman", "Sharma", 28000));
	    employees.add(new Employee("Aakash", "Yaadav", 53000));
	    employees.add(new Employee("James", "Hedge", 72000));
	    employees.add(new Employee("David", "Kameron", 19000));
	    employees.add(new Employee("Yash", "Chopra", 35000));
	    employees.add(new Employee("Karan", "Johar", 580000));
	    employees.add(new Employee("Balaji", "Subbu", 88000));
	    employees.add(new Employee("Vishu", "Bissi", 33000));
	    employees.add(new Employee("Lokesh", "Ramachandran", 60000));
	    return employees;
	}
	
	public static void main(String[] args) {

		List<Employee> employees  = getEmployees();
	     
	    //Sort all employees by first name
	    employees.sort(Comparator.comparing(e -> e.getFirstName()));
	     
	    //OR you can use below
	    employees.sort(Comparator.comparing(Employee::getFirstName));
	     
	    //Let's print the sorted list
	    System.out.println(employees);
	    
	    employees.sort(Comparator.comparing(Employee::getLastName));
	     
	    //Let's print the sorted list
	    System.out.println(employees);
	    
	  //Sorting on multiple fields; Group by.
	    Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName)
	                                                        .thenComparing(Employee::getSalary);
	    employees.sort(groupByComparator);
	     
	    System.out.println(employees);

	}

}
