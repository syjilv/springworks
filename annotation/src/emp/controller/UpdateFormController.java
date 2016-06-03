package emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emp.dto.MyEmpDTO;

@Controller
public class UpdateFormController {

	@RequestMapping(value = "/update_form.do", method = RequestMethod.POST)
	public ModelAndView runSearch(HttpServletRequest req, MyEmpDTO user) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("emp/update");
		return mav;
	}
}