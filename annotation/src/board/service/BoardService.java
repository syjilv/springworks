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
	void write(BoardDTO board);

	// �Խù� ����
	void modify(BoardDTO board);

	// �Խù� ����
	void delete(String boardNo);
	
	// ��ȸ��
	void viewCount(String boardNo);

	// �˻� �Խù� ī��Ʈ
	int searchCount(String target, String keyword);

	// �Խù� �˻�
	List<BoardDTO> search(String target, String keyword, int pageNo);

}