package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.service.MemberService;
import nju.fraborna.healthclub.service.WaiterService;

public class WaiterAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WaiterService waiterService = (WaiterService) ServiceFactory
			.getWaiterServiceInstance();
	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	private String[] datehm;
	private String[] address;
	private String[] coaches;
	private String[] changci;

	private String select;
	private String mid;

	private String search_mid;
	
	private String hidden;

	public String planEvent() {
		int num = waiterService.getActivitiesNum() + 10000;

		for (int i = 0; i < datehm.length; i++) {
			String activityID = "a" + num + "-" + changci[i].substring(2);
			waiterService.planActivity(activityID, "w10000", coaches[i],
					changci[i], datehm[i], address[i]);
		}

		return "success";
	}

	public String getCoachesIDs() {
		request.setAttribute("cids", waiterService.getCoachesIDs());
		
		return "success";
	}

	public String getActivitiesID() {
		request.setAttribute("aids", waiterService.getActivitiesIDs());
		return "success";
	}

	public String recordMid() {
		waiterService.recordMemberInActivity(select, mid);

		return "success";
	}

	public String getMemberInfo() {
		String info = memberService.getMemberBaseInfo(search_mid);

		request.setAttribute("message", info);

		return "success";
	}
	
	public String searchMemberBaseInfo() {
		String info =memberService.getMemberBaseInfo(hidden);
		
		request.setAttribute("memberBaseInfo", info);
		
		return "success";
	}
	
	public String searchMemberActInfo() {
		String activityRecord = memberService.getActivityRecord(hidden);

		request.setAttribute("activityRecord", activityRecord);
		
		return "success";
	}
	
	public String searchMemberPayInfo() {
		String payRecord = memberService.getPayRecord(hidden);

		request.setAttribute("payRecord", payRecord);
		
		return "success";
	}

	public String[] getDatehm() {
		return datehm;
	}

	public void setDatehm(String[] datehm) {
		this.datehm = datehm;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

	public String[] getCoaches() {
		return coaches;
	}

	public void setCoaches(String[] coaches) {
		this.coaches = coaches;
	}

	public String[] getChangci() {
		return changci;
	}

	public void setChangci(String[] changci) {
		this.changci = changci;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSearch_mid() {
		return search_mid;
	}

	public void setSearch_mid(String search_mid) {
		this.search_mid = search_mid;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

}
