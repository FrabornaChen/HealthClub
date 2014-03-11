package nju.fraborna.healthclub.action;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.service.ManagerService;

public class ManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManagerService managerService = (ManagerService) ServiceFactory
			.getManagerServiceInstance();

	public String getByAge() {
		String byage = managerService.getMembersByAge();

		request.setAttribute("byage", byage);

		return "success";
	}

	public String getBySex() {
		String bysex = managerService.getMemberBySex();

		request.setAttribute("bysex", bysex);

		return "success";
	}

	public String getByStatus() {
		String bystatus = managerService.getMemberByStatus();

		request.setAttribute("bystatus", bystatus);

		return "success";
	}

	public String getByAddress() {
		String byaddress = managerService.getMemberByAddress();

		request.setAttribute("byaddress", byaddress);

		return "success";
	}

	public String getInfoAboutField() {
		String fieldInfo = managerService.getInfoAboutField();

		request.setAttribute("fieldInfo", fieldInfo);

		return "success";
	}

	public String getInfoAboutCoach() {
		String coachinfo = managerService.getInfoAboutCoach();

		request.setAttribute("coachinfo", coachinfo);

		return "success";
	}

	public String getDayLoginNum() {
		int num = managerService.getDayLoginNum();

		request.setAttribute("login_num", "当天登录总人数为" + num + "人");

		return "success";
	}

	public String getMonthLoginNum() {
		int num = managerService.getMonthLoginNum();

		request.setAttribute("login_num", "当月登录总人数为" + num + "人");

		return "success";
	}

}
