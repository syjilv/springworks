package emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class SearchFormController extends AbstractController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse ares) throws Exception {
		return new ModelAndView("emp/search");
	}

}
