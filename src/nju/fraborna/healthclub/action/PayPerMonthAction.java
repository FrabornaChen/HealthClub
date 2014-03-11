package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.service.MemberService;

public class PayPerMonthAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	private String memberId;
	private double pay;
	
	private String chongzhi;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		memberId = (String) session.get("memberId");
		pay = memberService.getPaymentPerMonth(memberId);

		request.setAttribute("paypermonth", pay);

		return "success";
	}

	public String pay() {
		double addnum = Double.parseDouble(chongzhi);
		memberId = (String) session.get("memberId");

		memberService.addICNum(memberId, addnum);	
		
		return "success";
	}

	public String getICNum() {
		memberId = (String) session.get("memberId");

		double num = memberService.getICNum(memberId);

		request.setAttribute("icnum", num);

		return "success";
	}

	public String getChongzhi() {
		return chongzhi;
	}

	public void setChongzhi(String chongzhi) {
		this.chongzhi = chongzhi;
	}

}
