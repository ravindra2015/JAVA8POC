package org.springframework.samples.mvc.javapoc.customer;

import static org.springframework.samples.mvc.javapoc.customer.CustomerPredicate.filterCustomer;
import static org.springframework.samples.mvc.javapoc.customer.CustomerPredicate.isAge;
import static org.springframework.samples.mvc.javapoc.customer.CustomerPredicate.isCustomerPresent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	private static List<Customer> customerList = Arrays.asList(
			new Customer("Santosh", "Mali", 26, "Pune", LocalDate.of(2015, 5,15)),
			new Customer("Ravindra", "More", 28, "Mumbai", LocalDate.now()),
			new Customer("Minal", "Karale", 29, "Akola", LocalDate.now().plusMonths(5)),
			new Customer("Kedar", "Joshi", 30, "Kolhapur", LocalDate.of(2015, 5,15)),
			new Customer("Sameer", "Ahire", 29, "Pune", LocalDate.of(2015, 5,15)),
			new Customer("Rahul", "More", 29, "Mysore", LocalDate.of(2017, 5,15)),
			new Customer("Sushil", "Bora", 28, "Banglore", LocalDate.now().plus(1, ChronoUnit.YEARS).plusWeeks(3)),
			new Customer("Laxman", "More", 27, "Satara", LocalDateTime.now().toLocalDate()),
			new Customer("Satish", "Mali", 29, "Kolhapur", LocalDate.of(2015,5,15).plusMonths(5)));

	@RequestMapping("/customerform")
	public ModelAndView showform() {
		return new ModelAndView("customerform", "command", new Customer());
	}

	@RequestMapping("/sortCustomer")
	public ModelAndView sortform() {
		return new ModelAndView("sortCustomer", "command", new Customer());
	}
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
	public ModelAndView getlist(@ModelAttribute("customer") Customer customer) {

		List<Customer> customerShow = customerList.stream().collect(Collectors.toList());

		return new ModelAndView("customerList", "customerShow", customerShow);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchCustomer(@ModelAttribute("customer") Customer customer) {

		List<Customer> foundCustomer = filterCustomer(
				customerList,
				isCustomerPresent(customer.getFirstName(),
						customer.getLastName()));
		Collections.sort(foundCustomer, (c1, c2) -> c1.getDateOfRegister().compareTo(c2.getDateOfRegister()));

		return new ModelAndView("viewCustomer", "foundCustomer", foundCustomer);
	}
	
	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	public ModelAndView sortCustomer(@ModelAttribute("customer") Customer customer) {

		List<Customer> customerSort = filterCustomer(
				customerList,
				isAge(customer.getAge()));
		Collections.sort(customerSort, ((o1, o2)->o1.getAge()-o2.getAge()));

		return new ModelAndView("sortedCustomer", "customerSort", customerSort);
	}
}