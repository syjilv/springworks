package mydept;


public class MyDeptDTO{
	private String deptno;
	private String deptname;
	private String loc;
	private String telnum;
	
	public MyDeptDTO(){}

	public MyDeptDTO(String deptno, String deptname, String loc, String telnum) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.loc = loc;
		this.telnum = telnum;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	@Override
	public String toString() {
		return "MyDeptDTO [deptno=" + deptno + ", deptname=" + deptname
				+ ", loc=" + loc + ", telnum=" + telnum + "]";
	}
}
