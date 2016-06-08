package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDTO;
import board.service.BoardService;

@Controller
public class BoardListController {
	@Autowired
	BoardService service;

	// prameter�� ���� ��� ������ page=1 �� �ѱ�
	@RequestMapping(value="/board_list.do", params="!page")
	public ModelAndView list() {
		return runBoardList(1);
	}
	
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public ModelAndView runBoardList(int page) {
		ModelAndView mav = new ModelAndView();

		int count = service.count();
		List<BoardDTO> list = service.list(page);
		
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("board/list");

		return mav;
	}
}