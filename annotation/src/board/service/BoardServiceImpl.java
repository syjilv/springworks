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
	
	@Override
	public List<BoardDTO> list(int pageNo) {
		return dao.list(pageNo);
	}

	@Override
	public BoardDTO view(String boardNo) {
		return null;
	}

	@Override
	public void write(BoardDTO dto) {
		dao.write(dto);
	}

	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String boardNo) {
		// TODO Auto-generated method stub
		
	}

}
