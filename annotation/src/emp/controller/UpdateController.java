package emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emp.dto.MyEmpDTO;
import emp.service.MyEmpService;

@Controller
public class UpdateController {
	@Autowired
	MyEmpService service;
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView runSearch(HttpServletRequest req, MyEmpDTO emp, String id)  {
		System.out.println(emp + " : " + id);
		//service.update(emp);
		return new ModelAndView("redirect:list.do");
	}
}
