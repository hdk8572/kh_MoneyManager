package semi.dk.member.model.dto;

public class MemberDto {
	
	private String mid;
	private String mpwd; 
	private String mname;
	private String memail;
	
	@Override
	public String toString() {
		return "gagyabuDao [mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + ", memail=" + memail + "]";
	}

	public MemberDto(String mid, String mpwd) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
	}

	public MemberDto(String mid, String mpwd, String mname, String memail) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.mname = mname;
		this.memail = memail;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}
}
