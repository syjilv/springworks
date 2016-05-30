package emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchFormController {
	@RequestMapping("/search_form.do")
	public String main() {
		return "emp/search";
	}
}
