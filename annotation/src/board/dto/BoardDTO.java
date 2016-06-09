package board.dto;


public class BoardDTO{
	private String boardNo;
	private String memId;
	private String title;
	private String text;
	private int count;
	private String delFlg;
	private String regDtm;
	private String modDtm;
	private String memNm;

	public BoardDTO() {}

	public BoardDTO(String boardNo, String memId, String title, String text,
			int count, String delFlg, String regDtm, String modDtm, String memNm) {
		super();
		this.boardNo = boardNo;
		this.memId = memId;
		this.title = title;
		this.text = text;
		this.count = count;
		this.delFlg = delFlg;
		this.regDtm = regDtm;
		this.modDtm = modDtm;
		this.memNm = memNm;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getModDtm() {
		return modDtm;
	}

	public void setModDtm(String modDtm) {
		this.modDtm = modDtm;
	}
	
	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", memId=" + memId + ", title="
				+ title + ", text=" + text + ", count=" + count + ", delFlg="
				+ delFlg + ", regDtm=" + regDtm + ", modDtm=" + modDtm + "memNm=" + memNm + "]";
	}
	
}
