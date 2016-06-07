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
	public String logout(HttpSession session) {
		session.setAttribute("mem", null);
		return "redirect:index.do";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView runLogin(HttpSession session, String memId, String pwd) {
		ModelAndView mav = new ModelAndView();
		MemberDTO mem = service.login(memId, pwd);
		System.out.println("controller : " + mem.toString());

		if (mem != null) {
			session.setAttribute("mem", mem);
		}

		mav.setViewName("redirect:index.do");
		return mav;
	}
}