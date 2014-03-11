package nju.fraborna.healthclub.model;

public class Manager {

	private String mname;
	private String mpassword;

	public Manager(String mname, String mpassword) {
		super();
		this.mname = mname;
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

}
