package emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emp.dto.MyEmpDTO;

@Controller
public class UpdateFormController {

	@RequestMapping(value = "/update_form.do", method = RequestMethod.GET)
	public ModelAndView runSearch(HttpServletRequest req, String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("emp/update");
		return mav;
	}
}