package nju.fraborna.healthclub.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import nju.fraborna.healthclub.dao.ActivityDao;
import nju.fraborna.healthclub.dao.MemberDao;
import nju.fraborna.healthclub.dao.PayRecordDao;
import nju.fraborna.healthclub.factory.DaoFactory;
import nju.fraborna.healthclub.model.Member;
import nju.fraborna.healthclub.model.MemberStatus;

public class MemberService implements MemberServiceInterface {

	private static MemberService memberService = new MemberService();

	private MemberDao memberDaoImpl = DaoFactory.getMemberDaoImplInstance();
	private PayRecordDao payRecordDaoImpl = DaoFactory
			.getPayRecordDaoImplInstance();
	private ActivityDao activityDaoImpl = DaoFactory
			.getActivityDaoImplInstance();

	private MemberService() {

	}

	public static MemberService getInstance() {
		return memberService;
	}

	@Override
	public String registerSingleMember(Member member) {
		// TODO Auto-generated method stub
		int count = 0;
		String memberId;

		count = memberDaoImpl.countMembers();
		count += 100001;
		memberId = "s" + count;

		member.setMid(memberId);
		memberDaoImpl.addMember(member);

		return memberId;
	}

	@Override
	public String registerFamilyMember(ArrayList<Member> members) {
		// TODO Auto-generated method stub
		int count = 0;
		String memberId;

		count = memberDaoImpl.countMembers();
		count += 100001;
		memberId = "f" + count;

		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			member.setMid(memberId);
			memberDaoImpl.addMember(member);
		}

		return memberId;
	}

	@Override
	public String loginin(String id, String password) {
		// TODO Auto-generated method stub
		if (id.charAt(0) == 's') {
			Member member = memberDaoImpl.getSingleMemberBaseInfo(id);
			if (member != null) {
				if (member.getPassword().equals(password)) {
					if (!member.getStatus().equals(
							MemberStatus.CANCEL.toString()))
						return "ok";
					else
						return "notnormal";
				}
			}
		} else {
			ArrayList<Member> members = memberDaoImpl
					.getFamilyMembersBaseInfo(id);
			if (members.size() != 0) {
				if (members.get(0).getPassword().equals(password)) {
					if (!members.get(0).getStatus()
							.equals(MemberStatus.CANCEL.toString()))
						return "ok";
					else
						return "notnormal";
				}
			}
		}

		return "wrong";
	}

	public double getPayment(String id) {
		double activatePayment = 0;

		if (id.charAt(0) == 's') {
			activatePayment = 75;
		} else {
			activatePayment = 100;
		}

		return activatePayment;
	}

	public double getPaymentPerMonth(String id) {
		// boolean hasPayed = false;
		double paymentPerMonth = 0;

		// ArrayList<PayRecord> payRecords = new ArrayList<>();
		// payRecords = payRecordDaoImpl.getPayRecords(id);

		// for (PayRecord payRecord : payRecords) {
		// java.util.Date date = payRecord.getDate();
		// if (date.getMonth() == new java.util.Date().getMonth()) {
		// hasPayed = true;
		// break;
		// }
		// }

		// if (!hasPayed) {
		if (id.charAt(0) == 's') {
			paymentPerMonth = 40;
		} else {
			paymentPerMonth = 55;
			ArrayList<Member> members = memberDaoImpl
					.getFamilyMembersBaseInfo(id);
			for (Member member : members) {
				if (member.getAge() >= 10 & member.getAge() <= 18) {
					paymentPerMonth += 10;
				}
			}
		}
		// }

		return paymentPerMonth;
	}

	public void addPayRecord(String id, double payment) {
		payRecordDaoImpl.addPayRecord(id, payment, new Date(
				new java.util.Date().getTime()));
	}

	@Override
	public void cancelMember(String id) {
		// TODO Auto-generated method stub
		memberDaoImpl.alterStatus(id, "cancellation");
	}

	@Override
	public void bookEvent(String mid, String aid) {
		// TODO Auto-generated method stub
		activityDaoImpl.addActivityMember(aid, mid);
	}

	@Override
	public void alterMemberStatus(String id, String status) {
		// TODO Auto-generated method stub
		memberDaoImpl.alterStatus(id, status);
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		memberDaoImpl.deleteMember(id);
	}

	@Override
	public String getActivities() {
		// TODO Auto-generated method stub
		return activityDaoImpl.getActivities();
	}

	@Override
	public String getMemberBaseInfo(String id) {
		// TODO Auto-generated method stub
		String info = "";

		if (id.charAt(0) == 's') {
			Member member = memberDaoImpl.getSingleMemberBaseInfo(id);
			info += member.getMid() + "," + member.getName() + ","
					+ member.getAge() + "," + member.getSex() + ","
					+ member.getAddress() + "," + member.getStatus();
		} else {
			ArrayList<Member> members = memberDaoImpl
					.getFamilyMembersBaseInfo(id);
			for (Member m : members) {
				info += m.getMid() + "," + m.getName() + "," + m.getAge() + ","
						+ m.getSex() + "," + m.getAddress() + ","
						+ m.getStatus() + "&";
			}
			info = info.substring(0, info.length() - 1);
		}

		return info;
	}

	@Override
	public String getActivityRecord(String id) {
		// TODO Auto-generated method stub
		return activityDaoImpl.getActivityRecord(id);
	}

	@Override
	public String getPayRecord(String id) {
		// TODO Auto-generated method stub
		return payRecordDaoImpl.getPayRecord(id);
	}

	@Override
	public void addLoginRecord(String id) {
		// TODO Auto-generated method stub

		memberDaoImpl.addLoginRecord(id,
				new Date(new java.util.Date().getTime()));
	}

	@Override
	public String getAllMemberIDs() {
		// TODO Auto-generated method stub
		ArrayList<Member> members = memberDaoImpl.getAllMember();
		String ids = "";
		Set<String> set = new HashSet<>();

		for (Member member : members) {
			set.add(member.getMid());
		}

		for (String string : set) {
			ids += string;
			ids += ",";
		}

		return ids;
	}

	@Override
	public double getICNum(String id) {
		// TODO Auto-generated method stub
		return memberDaoImpl.getICNum(id);
	}

	@Override
	public void addICNum(String id, double num) {
		// TODO Auto-generated method stub
		double totalNum = num + getICNum(id);

		if (getICNum(id) < 0)
			totalNum = num;

		memberDaoImpl.addICNum(id, totalNum);
	}

	@Override
	public void bindIC(String id, String ic) {
		// TODO Auto-generated method stub
		memberDaoImpl.bindIC(id, ic);
	}

	@Override
	public boolean deleteICNum(String id, double num) {
		// TODO Auto-generated method stub
		double icnum = getICNum(id);
		double totalNum = 0;
		int status = memberDaoImpl.getICStatus(id);

		if (icnum < num) {
			if (status >= 6) {
				memberDaoImpl.setICStatus(id, 6);
				memberDaoImpl.alterStatus(id, MemberStatus.STOP.toString());
			} else {
				memberDaoImpl
						.setICStatus(id, memberDaoImpl.getICStatus(id) + 1);
				memberDaoImpl.alterStatus(id, MemberStatus.SUSPEND.toString());
			}
			return false;
		} else {
			if (memberDaoImpl.getSingleMemberBaseInfo(id).getStatus()
					.equals(MemberStatus.CANCEL.toString())) {
				return false;
			} else {
				totalNum = icnum - num;
				memberDaoImpl.deleteICNum(id, totalNum);
				memberDaoImpl.setICStatus(id, 0);
				memberDaoImpl.alterStatus(id, MemberStatus.NORMAL.toString());
				return true;
			}
		}
	}

	@Override
	public void alterBaseInfo(String id, String name, String age, String sex,
			String address) {
		// TODO Auto-generated method stub
		memberDaoImpl.alterBaseInfo(id, name, age, sex, address);
	}

	@Override
	public ArrayList<Member> getFamilyMembers(String id) {
		// TODO Auto-generated method stub
		return memberDaoImpl.getFamilyMembersBaseInfo(id);
	}

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		memberDaoImpl.addMember(member);
	}

}
