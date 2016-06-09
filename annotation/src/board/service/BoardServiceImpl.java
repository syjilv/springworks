package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boarddao")
	BoardDAO dao;
	
	// 게시물 수 조회
	@Override
	public int count() {
		return dao.count();
	}
	
	@Override
	public List<BoardDTO> list(int page) {
		return dao.list(page);
	}

	@Override
	public BoardDTO view(String boardNo) {
		return dao.view(boardNo);
	}

	@Override
	public void write(BoardDTO board) {
		dao.write(board);
	}

	@Override
	public void modify(BoardDTO board) {
		dao.modify(board);
	}

	@Override
	public void delete(String boardNo) {
		dao.delete(boardNo);
	}

	@Override
	public void viewCount(String boardNo) {
		dao.viewCount(boardNo);
	}

}
