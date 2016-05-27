package emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emp.dto.MyEmpDTO;
import emp.service.MyEmpService;

@Controller
public class InsertController {
	@Autowired
	MyEmpService service;
	
	// get������� ��û�� �� ������ �޼ҵ� - insert�������� response
	@RequestMapping(value="/insert.do", method=RequestMethod.GET)
	public String showPage() {
		return "emp/memberInput";
	}
	
	//post������� ��û�� �� ������ �޼ҵ�, - ���� db�� insert�ϱ� ���� ����� ���� 
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public ModelAndView runInsert(HttpServletRequest req, MyEmpDTO user, String id) {
		System.out.println(user + "_" + id);
		service.insert(user);
		return new ModelAndView("redirect:index.do");
	}
}
