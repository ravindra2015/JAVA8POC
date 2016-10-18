package org.springframework.samples.mvc.javapoc.existingcases;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CasePredicate {


	public static Predicate<Cases> isCasePresent(String firstName,String lastName) {
		return p -> p.getFirstname().equalsIgnoreCase(firstName)|| p.getLastname().equalsIgnoreCase(lastName);
	}
	
//	public static Predicate<Cases> isAge(int age) {
//        return p -> p.getAge() > age;
//    }
	public static Predicate<Cases> isRegDatePresent(LocalDate regDate) {
		return p -> p.getRegDate().equals(regDate);
}
	
	
	public static List<Cases> filterCases(List<Cases> cases,
			Predicate<Cases> predicate) {
		return cases.stream().filter(predicate)
				.collect(Collectors.<Cases> toList());
	}
}
