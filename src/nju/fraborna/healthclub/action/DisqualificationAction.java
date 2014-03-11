package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.model.MemberStatus;
import nju.fraborna.healthclub.service.MemberService;

public class DisqualificationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String id = (String) session.get("memberId");
		memberService.alterMemberStatus(id, MemberStatus.CANCEL.toString());
		return "success";
	}

}
