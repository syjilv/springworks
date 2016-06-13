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
	
	// �Խù� �� ��ȸ
	@Override
	public int count() {
		return dao.count();
	}
	
	@Override
	public List<BoardDTO> list(int pageNo) {
		return dao.list(pageNo);
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

	@Override
	public int searchCount(String target, String keyword) {
		return dao.searchCount(target, keyword);
	}

	@Override
	public List<BoardDTO> search(String target, String keyword, int pageNo) {
		return dao.search(target, keyword, pageNo);
	}

}
