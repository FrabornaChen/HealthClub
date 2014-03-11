package nju.fraborna.healthclub.dao;

import java.sql.Date;
import java.util.ArrayList;

import nju.fraborna.healthclub.model.Activity;
import nju.fraborna.healthclub.model.Member;
import nju.fraborna.healthclub.model.PayRecord;

public interface MemberDao {

	public boolean addMember(Member member);

	public Member getSingleMemberBaseInfo(String mid);

	public ArrayList<Member> getFamilyMembersBaseInfo(String id);

	public ArrayList<Activity> getMemberEventsRecord(String mid);

	public ArrayList<PayRecord> getMemberPayRecord(String mid);

	public boolean modifyMemberBaseInfo(Member member);

	public int countMembers();

	public void addLoginRecord(String id, Date date);

	public void alterStatus(String id, String status);

	public void deleteMember(String id);

	public ArrayList<Member> getAllMember();

	public double getICNum(String mid);

	public void addICNum(String id, double num);

	public void bindIC(String id, String ic);

	public void deleteICNum(String id, double num);

	public void setICStatus(String id, int status);

	public int getICStatus(String id);

	public void alterBaseInfo(String id, String name, String age, String sex,
			String address);

}
