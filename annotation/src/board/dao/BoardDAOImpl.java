package board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import emp.dto.MyEmpDTO;
import emp.dto.MyEmpRowMapper;
import board.dto.BoardDTO;
import board.dto.BoardRowMapper;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private JdbcTemplate template;
	
	// 목록 조회
	@Override
	public List<BoardDTO> list(int page) {
		String sql = "select u.BOARD_NO, u.MEM_ID, u.TITLE, u.TEXT, u.COUNT, u.DEL_FLG, u.REG_DTM, u.MOD_DTM from "
				   + "(select ROWNUM n, t.* from "
				   + "(select * from TB_BOARD where DEL_FLG = 'N' order by to_number(BOARD_NO) desc) t "
				   + "where ROWNUM <= " + (page * 10) + ") u "
				   + "where u.n >= " + (page * 10 - 9);
		return template.query(sql, new BoardRowMapper());
	}
	
	// 게시물 조회
	@Override
	public BoardDTO view(String boardNo) {
		BoardDTO dto = template.queryForObject("select * from TB_BOARD where BOARD_NO = ?", new Object[]{boardNo}, new BoardRowMapper());
		return dto;
	}
	
	// 게시물 작성
	@Override
	public void write(BoardDTO dto) {
		String sql = "insert into TB_BOARD values(SEQ_ID.NEXTVAL, ?, ?, ?, 0, 'N', to_char(sysdate, 'YYYYMMDDHH24MISS'), null)";
		int result = template.update(sql, dto.getMemId(), dto.getTitle(), dto.getText());
		System.out.println(result + " Record write 성공");
	}
	
	// 게시물 수정 
	@Override
	public void update(BoardDTO dto) {
		String sql = "update TB_BOARD set TITLE = ?, TEXT = ?, MOD_DTM = to_char(sysdate, 'YYYYMMDDHH24MISS') where BOARD_NO = ?";
		int result = template.update(sql, dto.getTitle(), dto.getText(), dto.getBoardNo());
		System.out.println(result + " Record Update 성공");
	}

	// 게시물 삭제
	@Override
	public void delete(String boardNo) {
		String sql = "update TB_BOARD set DEL_FLG = 'Y' where BOARD_NO = ?";
		int result = template.update(sql, boardNo);
		System.out.println(result + ". " + boardNo + " Delete 성공");
	}

}
