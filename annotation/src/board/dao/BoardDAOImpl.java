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

	// 게시물 수 조회
	@Override
	public int count() {
		return template.queryForObject("select count(*) from TB_BOARD where DEL_FLG = 'N'", Integer.class);
	}
	
	// 목록 조회
	@Override
	public List<BoardDTO> list(int page) {
		String sql = "select u.BOARD_NO, u.MEM_ID, u.TITLE, u.TEXT, u.COUNT, u.DEL_FLG, u.REG_DTM, u.MOD_DTM, u.MEM_NM from "
				   + "(select ROWNUM n, t.* from "
				   + "(select b.*, m.MEM_NM as MEM_NM from TB_BOARD b, TB_MEM m where b.MEM_ID = m.MEM_ID and DEL_FLG = 'N' order by to_number(BOARD_NO) desc) t "
				   + "where ROWNUM <= " + (page * 10) + ") u "
				   + "where u.n >= " + (page * 10 - 9);
		return template.query(sql, new BoardRowMapper());
	}
	
	// 게시물 조회
	@Override
	public BoardDTO view(String boardNo) {
		BoardDTO board = template.queryForObject("select b.*, m.MEM_NM from TB_BOARD b, TB_MEM m where b.MEM_ID = m.MEM_ID and BOARD_NO = ?", new Object[]{boardNo}, new BoardRowMapper());
		return board;
	}
	
	// 게시물 작성
	@Override
	public void write(BoardDTO board) {
		
		// DB 삽입 전 싱글쿼트 오류 방지용 replace
		board.setTitle(board.getTitle().replaceAll("'","′"));
		board.setText(board.getText().replaceAll("'","′"));

		String sql = "insert into TB_BOARD values(SEQ_ID.NEXTVAL, ?, ?, ?, 0, 'N', to_char(sysdate, 'YYYYMMDDHH24MISS'), null)";
		int result = template.update(sql, board.getMemId(), board.getTitle(), board.getText());
		System.out.println(result + " Record write 성공");
	}
	
	// 게시물 수정 
	@Override
	public void modify(BoardDTO board) {
		String sql = "update TB_BOARD set TITLE = ?, TEXT = ?, MOD_DTM = to_char(sysdate, 'YYYYMMDDHH24MISS') where BOARD_NO = ?";
		int result = template.update(sql, board.getTitle(), board.getText(), board.getBoardNo());
		System.out.println(result + " Record Update 성공");
	}
	
	// 조회수
	@Override
	public void viewCount(String boardNo) {
		template.update("update TB_BOARD set COUNT = (COUNT + 1) where BOARD_NO = ?", boardNo);
	}
	
	// 게시물 삭제
	@Override
	public void delete(String boardNo) {
		String sql = "update TB_BOARD set DEL_FLG = 'Y' where BOARD_NO = ?";
		int result = template.update(sql, boardNo);
		System.out.println(result + ". " + boardNo + " Delete 성공");
	}
	
}
