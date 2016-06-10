package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDTO;
import board.service.BoardService;

@Controller
public class ViewController {
	@Autowired
	BoardService service;

	// 게시물 번호가 없을 경우 목록으로 넘김
	@RequestMapping(value="/view.do", params="!boardNo")
	public ModelAndView view() {
		return new ModelAndView("redirect:board_list.do");
	}
	
	@RequestMapping(value="/view.do", method=RequestMethod.GET)
	public ModelAndView runView(String boardNo, String page) {
		ModelAndView mav = new ModelAndView();
		service.viewCount(boardNo);	// 조회수
		BoardDTO board = service.view(boardNo);
		mav.addObject("board", board);
		mav.setViewName("board/view");
		return mav;
	}
}