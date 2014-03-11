package nju.fraborna.healthclub.model;

import java.sql.Date;

public class Activity {

	private String aid;
	private String wid;
	private Date date;
	private String field;

	public Activity(String aid, String wid, Date date, String field) {
		super();
		this.aid = aid;
		this.wid = wid;
		this.date = date;
		this.field = field;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
