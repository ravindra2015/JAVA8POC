package org.springframework.samples.mvc.javapoc.ExistanceCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaseController {

	//LocalDate regDate;
	 static LocalDate today = LocalDate.now();
	 static LocalDate dummyDate = LocalDate.of(2013, 07, 02);

		private static List<Cases> cases = new ArrayList<Cases>();
		

		static {
			cases.add(new Cases("000IR3100VE", "Jenni", " Hartford", "20 20", LocalDate.of(2016, 07, 26)));
			cases.add(new Cases("000IR31P4NR", "George", "Bush", "20 20", today.minus(1, ChronoUnit.YEARS)));
			cases.add(new Cases("000IRUMFA88", "Bill", "Clinton", "10 11", today.minus(3, ChronoUnit.WEEKS)));
			cases.add(new Cases("000ISH1Q2DC", "Ronald", "Reagan", "70 72", today.minusMonths(5)));
			cases.add(new Cases("000ISH4L3MV", "Prasita", "Sarojakshan", "70 72", today.minusDays(20)));
			cases.add(new Cases("000ISH56FIO", "Rubin", "Klingler", "20 22", dummyDate.plus(90, ChronoUnit.DAYS)));
			cases.add(new Cases("000ISH56FIO", "Royal", "Gelb", "10 14", dummyDate.plusYears(2)));
			cases.add(new Cases("000ISH56FIO", "Ben", " Claar", "10 14", dummyDate.plusMonths(15)));	
			
			
			
		}public CaseController() {
			// TODO Auto-generated constructor stub
		}

		@RequestMapping(value = "/getlist", method = RequestMethod.GET)
		public ModelAndView getlist() {
			
			CasesForm casesForm = new CasesForm();
			casesForm.setCases(cases);
			
			
			return new ModelAndView("add_cases" , "casesForm", casesForm);
			
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ModelAndView save(@ModelAttribute("casesForm") CasesForm casesForm) {
			CasesForm caseForm = new CasesForm();
			caseForm.setCases(cases);
			System.out.println(casesForm);
			System.out.println(casesForm.getCases());
			List<Cases> cases = casesForm.getCases();
			
			if(null != cases && cases.size() > 0) {
				CaseController.cases = cases;
				for (Cases caseObj : cases) {
					System.out.printf("%s \t %s \n", caseObj.getFirstname(), caseObj.getLastname());
				}
			}
			
			return new ModelAndView("show_cases", "casesForm", casesForm);
		}
		
//		@RequestMapping(value = "/get", method = RequestMethod.GET)
//		public ModelAndView get() {
//			
//			CasesForm casesForm = new CasesForm();
//			casesForm.setCases(cases);
//			
//			return new ModelAndView("add_cases" , "casesForm", casesForm);
//		}
//		
//		@RequestMapping(value = "/save", method = RequestMethod.POST)
//		public ModelAndView save(@ModelAttribute("casesForm") CasesForm casesForm) {
//			System.out.println(casesForm);
//			System.out.println(casesForm.getCases());
//			List<Cases> cases = casesForm.getCases();
//			
//			if(null != cases && cases.size() > 0) {
//				CaseController.cases = cases;
//				for (Cases caseObj : cases) {
//					System.out.printf("%s \t %s \n", caseObj.getFirstname(), caseObj.getLastname());
//				}
//			}
//			
//			return new ModelAndView("show_cases", "casesForm", casesForm);
//		}
	}
