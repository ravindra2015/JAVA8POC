package com.santosh;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicate {

	public static Predicate<Person> isPerson() {
		return p -> p.getFirstName().equalsIgnoreCase("Satish")
				|| p.getLastName().equalsIgnoreCase("Mali");
	}
	
	public static Predicate<Person> isBalance(Integer age){
		return p->  p.getAge() > age ;
	}

	public static List<Person> filterPerson(List<Person> person,
			Predicate<Person> predicate) {
		return person.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}
}
