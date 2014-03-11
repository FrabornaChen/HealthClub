package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.model.MemberStatus;
import nju.fraborna.healthclub.service.MemberService;

public class ActivationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	private String memberId;
	private String cardID;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		memberId = (String) session.get("memberId");
		memberService.alterMemberStatus(memberId,
				MemberStatus.NORMAL.toString());
		memberService.bindIC(memberId, cardID);
		memberService
				.addPayRecord(memberId, memberService.getPayment(memberId));

		return "success";
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

}
