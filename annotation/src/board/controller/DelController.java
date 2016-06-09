package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.service.BoardService;

@Controller
public class DelController {
	@Autowired
	BoardService service;
	
	// parameter 값 없이 접근할 경우 목록으로 리턴
	@RequestMapping(value="/del.do", params="!boardNo")
	public String returnToList() {
		return "redirect:board_list.do";
	}
	
	@RequestMapping(value="/del.do", method=RequestMethod.GET)
	public String runDel(String boardNo) {
		service.delete(boardNo);
		return "redirect:board_list.do";
	}
	
//	@RequestMapping(value="/del.do", method=RequestMethod.POST)
//	public ModelAndView runModify(BoardDTO board) {
//		System.out.println("컨트롤러 : " + board.toString());
//		service.modify(board);
//		return new ModelAndView("redirect:board_list.do");
//	}
}
