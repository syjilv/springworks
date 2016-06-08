package board.service;

import java.util.List;

import board.dto.BoardDTO;
import emp.dto.MyEmpDTO;

public interface BoardService {

	// 게시물 수 조회
	public int count();

		// 목록 조회
	List<BoardDTO> list(int pageNo);

	// 게시물 조회
	BoardDTO view(String boardNo);

	// 게시물 작성
	void write(BoardDTO dto);

	// 게시물 수정
	void update(BoardDTO dto);

	// 게시물 삭제
	void delete(String boardNo);

	// 게시물 검색
	// List<BoardDTO> search(String query);

}