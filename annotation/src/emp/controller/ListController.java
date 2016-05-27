package emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import emp.dto.MyEmpDTO;
import emp.service.MyEmpService;

public class ListController implements Controller {
	MyEmpService service;
	
	public ListController(MyEmpService service) {
		super();
		this.service = service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse ares) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<MyEmpDTO> userlist = service.getMemberList();
		mav.addObject("userlist", userlist);
		mav.setViewName("emp/list");
		return mav;
	}

}
