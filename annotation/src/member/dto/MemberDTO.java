package member.dto;


public class MemberDTO{
	private String memId;
	private String memNm;
	private String memCd;
	private String pwd;
	private String pwdHint;
	private String pweHintAns;
	private String ssn;
	private String birthDt;
	private String maleFlg;
	private String telNo;
	private String cellNo;
	private String addr;
	private String email;
	private String emailRcvFlg;
	private String memRegDtm;
	
	public MemberDTO(){}
	
	public MemberDTO(String memId, String memNm, String memCd, String pwd,
			String pwdHint, String pweHintAns, String ssn, String birthDt,
			String maleFlg, String telNo, String cellNo, String addr,
			String email, String emailRcvFlg, String memRegDtm) {
		super();
		this.memId = memId;
		this.memNm = memNm;
		this.memCd = memCd;
		this.pwd = pwd;
		this.pwdHint = pwdHint;
		this.pweHintAns = pweHintAns;
		this.ssn = ssn;
		this.birthDt = birthDt;
		this.maleFlg = maleFlg;
		this.telNo = telNo;
		this.cellNo = cellNo;
		this.addr = addr;
		this.email = email;
		this.emailRcvFlg = emailRcvFlg;
		this.memRegDtm = memRegDtm;
		
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getMemCd() {
		return memCd;
	}

	public void setMemCd(String memCd) {
		this.memCd = memCd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdHint() {
		return pwdHint;
	}

	public void setPwdHint(String pwdHint) {
		this.pwdHint = pwdHint;
	}

	public String getPweHintAns() {
		return pweHintAns;
	}

	public void setPweHintAns(String pweHintAns) {
		this.pweHintAns = pweHintAns;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getBirthDt() {
		return birthDt;
	}

	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}

	public String getMaleFlg() {
		return maleFlg;
	}

	public void setMaleFlg(String maleFlg) {
		this.maleFlg = maleFlg;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailRcvFlg() {
		return emailRcvFlg;
	}

	public void setEmailRcvFlg(String emailRcvFlg) {
		this.emailRcvFlg = emailRcvFlg;
	}

	public String getMemRegDtm() {
		return memRegDtm;
	}

	public void setMemRegDtm(String memRegDtm) {
		this.memRegDtm = memRegDtm;
	}

	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", memNm=" + memNm + ", memCd="
				+ memCd + ", pwd=" + pwd + ", pwdHint=" + pwdHint
				+ ", pweHintAns=" + pweHintAns + ", ssn=" + ssn + ", birthDt="
				+ birthDt + ", maleFlg=" + maleFlg + ", telNo=" + telNo
				+ ", cellNo=" + cellNo + ", addr=" + addr + ", email=" + email
				+ ", emailRcvFlg=" + emailRcvFlg + ", memRegDtm=" + memRegDtm
				+ "]";
	}
}


