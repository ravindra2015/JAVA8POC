package org.springframework.samples.mvc.javapoc.existingcases;

import static org.springframework.samples.mvc.javapoc.existingcases.CasePredicate.filterCases;
import static org.springframework.samples.mvc.javapoc.existingcases.CasePredicate.isCasePresent;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaseController {

	// LocalDate regDate;
	static LocalDate today = LocalDate.now();
	static LocalDate dummyDate = LocalDate.of(2013, 07, 02);

	private static List<Cases> casesList = new ArrayList<Cases>();

	static {
		casesList.add(new Cases("000IR3100VE", "Jenni", " Hartford", "20 20",
				LocalDate.of(2016, 07, 26),"AWL"));
		casesList.add(new Cases("000IR31P4NR", "George", "Bush", "20 20", today
				.minus(1, ChronoUnit.YEARS),"EXTERNAL"));
		casesList.add(new Cases("000IRUMFA88", "Bill", "Clinton", "10 11", today
				.minus(3, ChronoUnit.WEEKS),"OTHERS"));
		casesList.add(new Cases("000ISH1Q2DC", "Ronald", "Reagan", "70 72", today
				.minusMonths(5),"AWL"));
		casesList.add(new Cases("000ISH4L3MV", "Vannesa", " Morocco", "70 72",
				today.minusDays(20),"EXTERNAL"));
		casesList.add(new Cases("000ISH56FIO", "Rubin", "Klingler", "20 22",
				dummyDate.plus(90, ChronoUnit.DAYS),"OTHERS"));
		casesList.add(new Cases("000ISSGJOMX", "Royal", "Gelb", "10 14", dummyDate
				.plusYears(2),"OTHERS"));
		casesList.add(new Cases("000ISTZ3T5B", "Ben", " Claar", "10 14", dummyDate
				.plusMonths(15),"AWL"));
	}

	public CaseController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public ModelAndView getlist() {

		CasesForm casesForm = new CasesForm();
		casesForm.setCases(casesList);
		
		return new ModelAndView("add_cases", "casesForm", casesForm);

	}

	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("casesForm") CasesForm casesForm) {
		System.out.println(casesForm);
		System.out.println(casesForm.getCases());
		List<Cases> cases = casesForm.getCases();

		if (null != cases && cases.size() > 0) {
			CaseController.casesList = cases;
			for (Cases caseObj : cases) {
				System.out.printf("%s \t %s \n", caseObj.getFirstname(), caseObj.getLastname());
			}
		}

		return new ModelAndView("show_cases", "casesForm", casesForm);
	}
	
	@RequestMapping(value="/displayCase", method=RequestMethod.POST)
	public ModelAndView displayList() {
		CasesForm casesForm = new CasesForm();
		casesForm.setCases(casesList);
		
		return new ModelAndView("displayCase", "casesForm", casesForm);
	}
	
	@RequestMapping(value = "/displayList", method = RequestMethod.POST)
	public ModelAndView display(@ModelAttribute("existanceCase") Cases existanceCase) {

		List<Cases> foundCases = filterCases(
				casesList, isCasePresent(existanceCase.getRefno(), existanceCase.getCallCenter()));


		return new ModelAndView("display_List", "foundCases", foundCases);
	}
	
	@RequestMapping(value = "/sorting", method = RequestMethod.GET)
		public ModelAndView sorting() {

		CasesForm casesForm = new CasesForm();
		casesForm.setCases(casesList);
	
	 		return new ModelAndView("sorting", "casesForm", casesForm);
	 	}
}