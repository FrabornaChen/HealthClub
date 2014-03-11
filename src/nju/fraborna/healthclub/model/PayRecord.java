package nju.fraborna.healthclub.model;

import java.sql.Date;

public class PayRecord {

	private String mid;
	private Date date;
	private double money;

	public PayRecord(String mid, Date date, double money) {
		super();
		this.mid = mid;
		this.date = date;
		this.money = money;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
