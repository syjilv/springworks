package emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import emp.dto.MyEmpDTO;
import emp.service.MyEmpService;

public class SearchController implements Controller {
	MyEmpService service;
	String addr;
	
	public SearchController(MyEmpService service) {
		super();
		this.service = service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		req.setCharacterEncoding("EUC-KR");
		addr = (String) req.getParameter("search"); 
		List<MyEmpDTO> userlist = service.findByAddr(addr);
		
		mav.addObject("userlist", userlist);
		mav.setViewName("emp/searchlist");
		return mav;
	}
}
