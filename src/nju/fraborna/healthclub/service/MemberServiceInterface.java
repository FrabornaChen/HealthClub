package nju.fraborna.healthclub.service;

import java.util.ArrayList;

import nju.fraborna.healthclub.model.Member;

public interface MemberServiceInterface {

	public String registerSingleMember(Member member);

	public String registerFamilyMember(ArrayList<Member> members);

	public String loginin(String id, String password);

	public void addPayRecord(String id, double payment);

	public void addLoginRecord(String id);

	public double getPayment(String id);

	public double getPaymentPerMonth(String id);

	public void cancelMember(String id);

	public String getActivities();

	public void bookEvent(String mid, String aid);

	public void alterMemberStatus(String id, String status);

	public void deleteMember(String id);

	public String getMemberBaseInfo(String id);

	public String getActivityRecord(String id);

	public String getPayRecord(String id);

	public String getAllMemberIDs();

	public double getICNum(String id);

	public void addICNum(String id, double num);

	public boolean deleteICNum(String id, double num);

	public void bindIC(String id, String ic);

	public void alterBaseInfo(String id, String name, String age, String sex,
			String address);

	public ArrayList<Member> getFamilyMembers(String id);

	public void addMember(Member member);

}
