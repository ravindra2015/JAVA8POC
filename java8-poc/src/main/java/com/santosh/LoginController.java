package com.santosh;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login(){
		return "redirect:/login";
	}
	@RequestMapping(value="userCheck", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("firstName");
		String pwd=request.getParameter("lastName");
		
		List<Login> loginList = Stream
				.of(new Login("Santosh", "Mali")).collect(
						Collectors.toList());

		// System.out.println("List of Person's are:-");
		// personList.forEach(System.out::println");
		List<Login> foundObjs = loginList
				.stream()
				.filter(person -> person.getFirstName().equalsIgnoreCase(
						name))
						.distinct()
						.collect(Collectors.toList());

		if (null != foundObjs) {
			model.addAttribute("message", "Successfully logged in.");
			System.out.println("Searched Person is:");
			foundObjs.forEach(System.out::println);
		} else {
			System.out.println("Could not found objects in list");
			model.addAttribute("message", "Username or password is wrong.");
		}
		return "redirect:success.jsp";
	}
}

