package board.dao;

import java.util.List;

import board.dto.BoardDTO;
import emp.dto.MyEmpDTO;

public interface BoardDAO {

	// �Խù� �� ��ȸ
	int count();
	
	// ��� ��ȸ
	List<BoardDTO> list(int page);

	// �Խù� ��ȸ
	BoardDTO view(String boardNo);

	// �Խù� �ۼ�
	void write(BoardDTO board);

	// �Խù� ����
	void update(BoardDTO board);

	// �Խù� ����
	void delete(String boardNo);

	// �Խù� �˻�
	// List<BoardDTO> search(String query);

}