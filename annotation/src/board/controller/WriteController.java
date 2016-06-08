package board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDTO;
import board.service.BoardService;

@Controller
public class WriteController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public ModelAndView runWrite(HttpServletRequest request, BoardDTO board) {
		service.write(board);
		return new ModelAndView("redirect:board_list.do");
	}
}
