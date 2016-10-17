package org.springframework.samples.mvc.javapoc.broker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/broker")
@SessionAttributes("brokerBean")
public class BrokerController {

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see
	// @SessionAttributes)

	@ModelAttribute("brokerBean")
	public BrokerBean createBrokerBean() {
		return new BrokerBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@Valid BrokerBean formBean, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return null;
		}

		List<String> countryList = new ArrayList<String>();
		List<String> countryList1 = new ArrayList<String>();
		try {
			countryList = BrokerDetails.getBrokers(formBean.getAccountNo());
			
			/* Start: Older Java Version Sorting Way */
  		    Collections.sort(countryList, new Comparator<String>() {
				public int compare(String p1, String p2) {
					return p1.compareTo(p2);
				}
			});

			/* :End */

			// Java 8 Stream used to sort

			     countryList=countryList.stream().sorted().collect(Collectors.toList());
			     
			    /*Reverse Order
			     *  countryList.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator().forEachRemaining(ss->countryList1.add(ss));
			     countryList1.forEach(System.out::println);
*/			     
			// Java 8 List sort method used with Lambda to sort the list
		       //countryList.sort((p1, p2) -> p1.compareTo(p2));

			     
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("brokerList", countryList);
			return null;
		} else {
			redirectAttrs.addAttribute("brokerBean", new BrokerBean());

			return "redirect:/broker";
		}
	}

}
