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
			new Customer("Avinash", "Renuakarya", 35, "Banglore", LocalDate.of(2010, 3,13)),
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

		List<Customer> getCustomerList = customerList.stream().collect(Collectors.toList());

		return new ModelAndView("customerList", "getCustomerList", getCustomerList);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchCustomer(@ModelAttribute("customer") Customer customer) {

		List<Customer> foundCustomer = filterCustomer(
				customerList,
				isCustomerPresent(customer.getFirstName(),
						customer.getLastName()));

		return new ModelAndView("viewCustomer", "foundCustomer", foundCustomer);
	}
	
	@RequestMapping(value = "/sortByAge", method = RequestMethod.GET)
	public ModelAndView sortCustomer(@ModelAttribute("customer") Customer customer) {

		List<Customer> foundCustomer = filterCustomer(
				customerList,
				isAge(customer.getAge()));
		Collections.sort(foundCustomer, ((o1, o2)->o1.getAge()-o2.getAge()));

		return new ModelAndView("customerList", "getCustomerList", foundCustomer);
	}
	
	@RequestMapping(value = "/sortByDate", method = RequestMethod.GET)
	public ModelAndView sortCustomerByDate(@ModelAttribute("customer") Customer customer) {
		
		customerList.sort((Customer o1, Customer o2)->o1.getDateOfRegister().compareTo(o2.getDateOfRegister()));
		return new ModelAndView("customerList", "getCustomerList", customerList);
	}
	
	@RequestMapping(value = "/sortByFirstName", method = RequestMethod.GET)
	public ModelAndView sortCustomerByFirstName(@ModelAttribute("customer") Customer customer) {

		customerList.sort((Customer o1, Customer o2)->o1.getFirstName().compareTo(o2.getFirstName()));
		return new ModelAndView("customerList", "getCustomerList", customerList);
	}
	
	@RequestMapping(value = "/sortByLastName", method = RequestMethod.GET)
	public ModelAndView sortCustomerByLastName(@ModelAttribute("customer") Customer customer) {

		customerList.sort((Customer o1, Customer o2)->o1.getLastName().compareTo(o2.getLastName()));
		return new ModelAndView("customerList", "getCustomerList", customerList);
	}
	
	@RequestMapping(value = "/sortByCity", method = RequestMethod.GET)
	public ModelAndView sortCustomerByCity(@ModelAttribute("customer") Customer customer) {

		customerList.sort((Customer o1, Customer o2)->o1.getCity().compareTo(o2.getCity()));
		return new ModelAndView("customerList", "getCustomerList", customerList);
	}
	
}