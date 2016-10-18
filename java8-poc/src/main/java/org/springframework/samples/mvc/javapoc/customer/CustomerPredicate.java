package org.springframework.samples.mvc.javapoc.customer;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class CustomerPredicate {

	public static Predicate<Customer> isCustomerPresent(String firstName,String lastName) {
		return p -> p.getFirstName().equalsIgnoreCase(firstName)|| p.getLastName().equalsIgnoreCase(lastName);
	}
	
	public static Predicate<Customer> isAge(int age) {
        return p -> p.getAge() > age;
    }
	
	public static List<Customer> filterCustomer(List<Customer> customer,
			Predicate<Customer> predicate) {
		return customer.stream().filter(predicate)
				.collect(Collectors.<Customer> toList());
	}
}
