package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.service.MyEmpService;

public class ListController extends AbstractController {
	MyEmpService service;
	
	public ListController(MyEmpService service) {
		super();
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse ares) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userlist", service.getMemberList());
		mav.setViewName("emp/list");
		return mav;
	}

}
