package com.santosh;

import static com.santosh.PersonPredicate.filterPerson;
import static com.santosh.PersonPredicate.isPerson;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonInfo {
	
	public static void main(String[] args) {

		List<Person> personList = Stream
				.of(new Person("Santosh", "Mali",new BigDecimal("3000")),
						new Person("Sushil", "Bora",new BigDecimal("5000")),
						new Person("Badrinath", "Ajabe",new BigDecimal("13000")),
						new Person("Santosh", "Mali",new BigDecimal("15000")),
						new Person("Shankar", "Ajabe",new BigDecimal("31000")),
						new Person("Pradeep", "Bhapkar",new BigDecimal("33000")),
						new Person("Shailesh", "Firangey",new BigDecimal("35000")),
						new Person("Suraj", "Chordia",new BigDecimal("8000")),
						new Person("Avinash", "Gawade",new BigDecimal("3500"))).collect(
						Collectors.toList());

		// System.out.println("List of Person's are:-");
		// personList.forEach(System.out::println");
		List<Person> foundObjs = personList
				.stream()
				.filter(person -> person.getFirstName().equalsIgnoreCase(
						"Satish"))
						.distinct()
						.collect(Collectors.toList());

		if (null != foundObjs) {
			System.out.println("Searched Person is:");
			foundObjs.forEach(System.out::println);
		} else {
			System.out.println("Could not found objects in list");
		}

		System.out.println("Using Predicate");
		System.out.println(filterPerson(personList, isPerson()));
		System.out.println(filterPerson(personList, isPerson()));

		// Creating Comparator to compare Balance of Customers
		final Comparator<Person> BALANCE_COMPARATOR = new Comparator<Person>() {
			@Override
			public int compare(Person t1, Person t2) {
				return t1.getBalance().compareTo(t2.getBalance());
			}
		};

		// sorting objects using Comparator by price 
		System.out.println("List of training courses, before sorting"); 
		System.out.println(personList); 
		Collections.sort(personList, BALANCE_COMPARATOR);
		System.out.println("After sorting by price, increasing order"); 
		System.out.println(personList);
		
		System.out.println("Sorting objects in decreasing order of price, using lambdas"); 
		Collections.sort(personList, (c1, c2) -> c2.getBalance().compareTo(c1.getBalance())); 
		System.out.println(personList);
		
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println(LocalDate.now().isAfter(LocalDate.of(2016, 10, 11)));
		System.out.println(LocalDate.now().plusDays(7));
		System.out.println(LocalDate.now().plusWeeks(3));
		System.out.println(LocalDate.now().plusMonths(5));
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_WEEK_DATE));
	}
}
