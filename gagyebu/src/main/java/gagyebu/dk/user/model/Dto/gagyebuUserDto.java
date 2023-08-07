package gagyebu.dk.user.model.Dto;

public class gagyebuUserDto {

//			CREATE TABLE "EX" (
//			"INSERT_DATE"	VARCHAR2(20)  		NOT NULL,
//			"NO"	        NUMBER		        NOT NULL,
//			"MID"	        VARCHAR2(20)		NOT NULL,
//			"PRICE"	        NUMBER		        NOT NULL,
//			"CATEGORY"	    VARCHAR(20)	    	NOT NULL,
//			"CASHCARD"	    VARCHAR(20)	    	NOT NULL,
//			"NAME"	        VARCHAR2(50)	    	NOT NULL,
//			"DESCRIPTION"	VARCHAR(50)	    	NULL
//		);
	
	private String insertDate;
	private int mno;
	private String mid;
	private int mprice;
	private String category;
	private String cashCard;
	private String mname;
	private String descripion;
	
	@Override
	public String toString() {
		return "gagyebuUserDto [insertDate=" + insertDate + ", mno=" + mno + ", mid=" + mid + ", mprice=" + mprice
				+ ", category=" + category + ", cashCard=" + cashCard + ", mname=" + mname + ", descripion="
				+ descripion + "]";
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getMprice() {
		return mprice;
	}

	public void setMprice(int mprice) {
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

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}
}
