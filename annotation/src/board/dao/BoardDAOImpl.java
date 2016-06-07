package board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import board.dto.BoardDTO;
import board.dto.BoardRowMapper;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private JdbcTemplate template;

	// ��� ��ȸ
	@Override
	public List<BoardDTO> list(int pageNo) {
		String sql = "select * from "
				   + "(select * from "
				   + "(select * from TB_BOARD where DEL_FLG = 'N' order by BOARD_NO desc) "
				   + "where rownum <= " + (pageNo * 10) + ") "
				   + "where rownum >= " + (pageNo * 10 - 9);
		return template.query(sql, new BoardRowMapper());
	}
	
	// �Խù� ��ȸ
	@Override
	public BoardDTO view(String boardNo) {
		BoardDTO dto = template.queryForObject("select * from TB_BOARD where BOARD_NO = ?", new Object[]{boardNo}, new BoardRowMapper());
		return dto;
	}
	
	// �Խù� �ۼ�
	@Override
	public void write(BoardDTO dto) {
		String sql = "insert into TB_BOARD values(SEQ_ID.NEXTVAL, ?, ?, ?, 0, 'N', to_char(sysdate, 'YYYYMMDDHH24MISS'), null)";
		int result = template.update(sql, dto.getMemId(), dto.getTitle(), dto.getText());
		System.out.println(result + " Record write ����");
	}
	
	// �Խù� ���� 
	@Override
	public void update(BoardDTO dto) {
		String sql = "update TB_BOARD set TITLE = ?, TEXT = ?, MOD_DTM = to_char(sysdate, 'YYYYMMDDHH24MISS') where BOARD_NO = ?";
		int result = template.update(sql, dto.getTitle(), dto.getText(), dto.getBoardNo());
		System.out.println(result + " Record Update ����");
	}

	// �Խù� ����
	@Override
	public void delete(String boardNo) {
		String sql = "update TB_BOARD set DEL_FLG = 'Y' where BOARD_NO = ?";
		int result = template.update(sql, boardNo);
		System.out.println(result + ". " + boardNo + " Delete ����");
	}

}
