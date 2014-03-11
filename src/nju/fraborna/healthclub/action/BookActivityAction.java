package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.service.MemberService;

public class BookActivityAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	//	String id = (String) session.get("memberId");
		
		return "success";
	}

	public String getActivities() {
		String activitiesInfo = "";

		activitiesInfo = memberService.getActivities();

		request.setAttribute("activities", activitiesInfo);

		return "success";
	}

}
