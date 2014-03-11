package nju.fraborna.healthclub.model;

import java.sql.Date;

public class Waiter {
	
	private String wid;
	private String wpassword;
	private String wname;
	private int wage;
	private Date indate;
	
	public Waiter(String wid, String wpassword, String wname, int wage,
			Date indate) {
		super();
		this.wid = wid;
		this.wpassword = wpassword;
		this.wname = wname;
		this.wage = wage;
		this.indate = indate;
	}
	
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWpassword() {
		return wpassword;
	}
	public void setWpassword(String wpassword) {
		this.wpassword = wpassword;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
}
