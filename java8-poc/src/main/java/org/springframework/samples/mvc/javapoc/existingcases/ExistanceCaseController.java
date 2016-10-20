package org.springframework.samples.mvc.javapoc.existingcases;

import java.util.Optional;

import javax.validation.Valid;

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
@RequestMapping("/existanceCase")
@SessionAttributes("existanceCaseBean")
public class ExistanceCaseController {
	
	CasesForm casesForm = new CasesForm();
	ExistanceCaseBean existanceCaseBean;

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping(value="/processForm",params="action1",method=RequestMethod.POST)
    public void action1()
    {
        System.out.println("Action1 block called");
    }
    @RequestMapping(value="/processForm",params="action2",method=RequestMethod.POST)
    public void action2()
    {
        System.out.println("Action2 block called");
    }

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

	
	@ModelAttribute("existanceCaseBean")
	public ExistanceCaseBean createFormBean() {
		return new ExistanceCaseBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
	} 

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid ExistanceCaseBean formBean, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return null;
		}
		
		
//		String button = request.getParameter("ExistanceCase");
//		if ("ExistanceCase".equals(button)){
//	   
//	}
		casesForm.getCases().stream().filter(s-> s.getRefno().equals(formBean.getRefno())).forEach(e -> System.out.println("List>>>>>>>>>>>>>" +e.getRegDate() + e.getFirstname()));
		Optional stringToUse = Optional.of(formBean.getRefno());
		if( stringToUse.isPresent())
		{
        casesForm.getCases().stream().filter(s-> s.getRefno().equals(formBean.getRefno())).forEach(e -> System.out.println("List>>>>>>>>>>>>>" +e.getRegDate() + e.getFirstname()));
		}
   
//        return new ModelAndView("redirect:/displayList");//will redirect to viewemp request mapping  
//    }
		
//		List callCenterList = new ArrayList();
//		callCenterList.add("AWL");
//		callCenterList.add("EXTERNAL");
//		callCenterList.add("OTHERS");
		
		// Typically you would save to a db and clear the "form" attribute from the session 
		// via SessionStatus.setCompleted(). For the demo we leave it in the session.
		String message = "Form submitted successfully.  Bound " + formBean;
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
//			model.addAttribute("callCenterList", callCenterList);
			return null;
		} else {
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/existanceCase";	
//			return "redirect:/save";
		}
	}
	
}
