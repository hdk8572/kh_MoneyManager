package semi.dk.user.model.dto;

public class UserDto {

	private String insertDate; 
	private String mno;
	private String mid;
	private String mprice;
	private String category;
	private String cashCard;
	private String mname;
	private String description;
	
	@Override
	public String toString() {
		return "gagyebuListDto [insertDate=" + insertDate + ", mno=" + mno + ", mid=" + mid + ", mprice=" + mprice
				+ ", category=" + category + ", cashCard=" + cashCard + ", mname=" + mname + ", description="
				+ description + "]";
	}

	public UserDto() {
		super();
	}

	public UserDto(String insertDate, String mno, String mid, String mprice, String category, String cashCard,
			String mname, String description) {
		super();
		this.insertDate = insertDate;
		this.mno = mno;
		this.mid = mid;
		this.mprice = mprice;
		this.category = category;
		this.cashCard = cashCard;
		this.mname = mname;
		this.description = description;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMprice() {
		return mprice;
	}

	public void setMprice(String mprice) {
		this.mprice = mprice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCashCard() {
		return cashCard;
	}

	public void setCashCard(String cashCard) {
		this.cashCard = cashCard;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}