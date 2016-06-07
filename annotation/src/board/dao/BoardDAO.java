package board.dao;

import java.util.List;

import board.dto.BoardDTO;
import emp.dto.MyEmpDTO;

public interface BoardDAO {

	// ��� ��ȸ
	List<BoardDTO> list(int page);

	// �Խù� ��ȸ
	BoardDTO view(String boardNo);

	// �Խù� �ۼ�
	void write(BoardDTO dto);

	// �Խù� ����
	void update(BoardDTO dto);

	// �Խù� ����
	void delete(String boardNo);

	// �Խù� �˻�
	// List<BoardDTO> search(String query);

}