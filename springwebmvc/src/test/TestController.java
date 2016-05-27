package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// ������ ��� ������ �����Ϳ� ���� ������ ���� �ִ� ��ü
		ModelAndView mav = new ModelAndView();
		// ������ �����͸� ���� - request.setAttribute(�� ����);
		mav.addObject("msg", "���������� �Ѿ�� �����;�7777777777777777777777777");
		//forward�� �信 ���� ������ ����
		mav.setViewName("test/result");
		return mav;
	}

}
