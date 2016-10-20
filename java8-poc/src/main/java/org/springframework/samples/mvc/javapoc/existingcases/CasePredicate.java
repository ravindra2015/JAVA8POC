package org.springframework.samples.mvc.javapoc.existingcases;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CasePredicate {


	public static Predicate<Cases> isCasePresent(String refno,String callCenter) {
		System.out.println("@@@@@@@@@"+refno);
		return p -> p.getRefno().equalsIgnoreCase(refno)|| p.getCallCenter().equalsIgnoreCase(callCenter);
	}
	
	public static List<Cases> filterCases(List<Cases> cases,
			Predicate<Cases> predicate) {
		return cases.stream().filter(predicate)
				.collect(Collectors.<Cases> toList());
	}
}
