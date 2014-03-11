package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.model.Member;
import nju.fraborna.healthclub.service.MemberService;

public class CheckInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	private String memberId = "";

	private String[] name;
	private String[] age;
	private String[] sex;
	private String[] address;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public String getBaseInfo() {
		memberId = (String) session.get("memberId");

		String info = memberService.getMemberBaseInfo(memberId);

		request.setAttribute("memberBaseInfo", info);

		return "success";
	}

	public String getActivityRecord() {
		memberId = (String) session.get("memberId");

		String activityRecord = memberService.getActivityRecord(memberId);

		request.setAttribute("activityRecord", activityRecord);

		return "success";
	}

	public String getPayRecord() {
		memberId = (String) session.get("memberId");

		String payRecord = memberService.getPayRecord(memberId);

		request.setAttribute("payRecord", payRecord);

		return "success";
	}

	public String alterBaseInfo() {
		memberId = (String) session.get("memberId");

		if (memberId.charAt(0) == 'f') {
			Member member = memberService.getFamilyMembers(memberId).get(0);

			memberService.deleteMember(memberId);

			for (int i = 0; i < name.length; i++) {
				memberService.addMember(new Member(memberId, member
						.getPassword(), name[i], Integer.parseInt(age[i]),
						sex[i], address[i], member.getStatus()));
			}
		} else {
			for (int i = 0; i < name.length; i++) {
				memberService.alterBaseInfo(memberId, name[i], age[i], sex[i],
						address[i]);
			}
		}

		return "success";
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getAge() {
		return age;
	}

	public void setAge(String[] age) {
		this.age = age;
	}

	public String[] getSex() {
		return sex;
	}

	public void setSex(String[] sex) {
		this.sex = sex;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

}
