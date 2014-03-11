package nju.fraborna.healthclub.model;

public class Member {

	private String mid;
	private String password;
	private String name;
	private String sex;
	private int age;
	private String address;
	private String status;

	public Member(String mid, String password, String name, int age,
			String sex, String address, String status) {
		super();
		this.mid = mid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.status = status;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
