package board.service;

import java.util.List;

import board.dto.BoardDTO;
import emp.dto.MyEmpDTO;

public interface BoardService {

	// �Խù� �� ��ȸ
	public int count();

		// ��� ��ȸ
	List<BoardDTO> list(int pageNo);

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