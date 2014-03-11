package nju.fraborna.healthclub.model;

public class Coach {

	private String cid;
	private String cname;
	private String csex;

	public Coach(String cid, String cname, String csex) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.csex = csex;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCsex() {
		return csex;
	}

	public void setCsex(String csex) {
		this.csex = csex;
	}

}
