package member.controller;

import javax.servlet.http.HttpSession;

import member.dto.MemberDTO;
import member.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	MemberService service;

	// ·Î±×¾Æ¿ô
	@RequestMapping("logout.do")
	public String logout(HttpSession session, String ref) {
		session.invalidate();
		return "redirect:" + ref + ".do";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView loginForm(String ref) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ref", ref);
		mav.setViewName("member/login");
		return mav;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String runLogin(HttpSession session, String memId, String pwd, String ref) {
		MemberDTO mem = service.login(memId, pwd);
		if (mem != null) {
			session.setAttribute("mem", mem);
		}
		return "redirect:" + ref + ".do";
	}
}