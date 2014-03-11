package nju.fraborna.healthclub.action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.model.Member;
import nju.fraborna.healthclub.model.MemberStatus;
import nju.fraborna.healthclub.service.MemberService;

public class RegisterAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	private String member_type;
	private String[] member_name;
	private int[] member_age;
	private String[] member_sex;
	private String s_province;
	private String s_city;
	private String s_county;
	private String member_password1;
	private String member_password2;

	private String message = "";
	private String memberId;
	private Member member;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		if (!member_password1.equals(member_password2)) {
			message = "两次密码不一致，请重新输入！";
			request.setAttribute("message", message);
			return "false";
		} else {
			if (member_type.equals("1")) {
				member = new Member("", member_password2, member_name[0],
						member_age[0], member_sex[0], s_province + "/" + s_city
								+ "/" + s_county,
						MemberStatus.NONACTIVATE.toString());
				memberId = memberService.registerSingleMember(member);
			} else {
				ArrayList<Member> members = new ArrayList<>();
				for (int i = 0; i < member_name.length; i++) {
					member = new Member("", member_password2, member_name[i],
							member_age[i], member_sex[i], s_province + "/"
									+ s_city + "/" + s_county,
							MemberStatus.NONACTIVATE.toString());
					members.add(member);
				}
				memberId = memberService.registerFamilyMember(members);
			}
			request.setAttribute("memberId", memberId);

			// 添加session和cookie
			session.put("memberId", memberId);
			Cookie cookie = new Cookie("memberId", memberId);
			response.addCookie(cookie);

			return "success";
		}
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String getMember_type() {
		return member_type;
	}

	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	public String[] getMember_name() {
		return member_name;
	}

	public void setMember_name(String[] member_name) {
		this.member_name = member_name;
	}

	public int[] getMember_age() {
		return member_age;
	}

	public void setMember_age(int[] member_age) {
		this.member_age = member_age;
	}

	public String[] getMember_sex() {
		return member_sex;
	}

	public void setMember_sex(String[] member_sex) {
		this.member_sex = member_sex;
	}

	public String getS_province() {
		return s_province;
	}

	public void setS_province(String s_province) {
		this.s_province = s_province;
	}

	public String getS_city() {
		return s_city;
	}

	public void setS_city(String s_city) {
		this.s_city = s_city;
	}

	public String getS_county() {
		return s_county;
	}

	public void setS_county(String s_county) {
		this.s_county = s_county;
	}

	public String getMember_password1() {
		return member_password1;
	}

	public void setMember_password1(String member_password1) {
		this.member_password1 = member_password1;
	}

	public String getMember_password2() {
		return member_password2;
	}

	public void setMember_password2(String member_password2) {
		this.member_password2 = member_password2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
