package board.dao;

import java.util.List;

import board.dto.BoardDTO;
import emp.dto.MyEmpDTO;

public interface BoardDAO {

	// 게시물 수 조회
	int count();
	
	// 목록 조회
	List<BoardDTO> list(int pageNo);

	// 게시물 조회
	BoardDTO view(String boardNo);

	// 게시물 작성
	void write(BoardDTO board);

	// 게시물 수정
	void modify(BoardDTO board);

	// 게시물 삭제
	void delete(String boardNo);

	// 조회수
	void viewCount(String boardNo);

	// 검색 게시물 카운트
	int searchCount(String target, String keyword);

	// 게시물 검색
	List<BoardDTO> search(String target, String keyword, int pageNo);

}