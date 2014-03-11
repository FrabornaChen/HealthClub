package nju.fraborna.healthclub.action;

import javax.servlet.http.Cookie;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.service.ManagerService;
import nju.fraborna.healthclub.service.MemberService;
import nju.fraborna.healthclub.service.WaiterService;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();
	private ManagerService managerService = (ManagerService) ServiceFactory
			.getManagerServiceInstance();
	private WaiterService waiterService = (WaiterService) ServiceFactory
			.getWaiterServiceInstance();

	private String identity;
	private String id;
	private String password;

	private String message = "";

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		if (id.equals("") || password.equals("")) {
			message = "�뽫���ź�������д������";
			request.setAttribute("message", message);
			return "false";
		}

		if (identity.equals("��Ա")) {
			String isSuccess = memberService.loginin(id, password);
			if (isSuccess.equals("ok")) {
				memberService.addLoginRecord(id);

				// ���session��cookie
				session.put("memberId", id);
				Cookie cookie = new Cookie("memberId", id);
				response.addCookie(cookie);

				return "success";
			} else if (isSuccess.equals("wrong")) {
				message = "���Ż�����������������룡";
				request.setAttribute("message", message);
				return "false";
			} else {
				message = "��Ա�ʸ���ע����������<a href='register.jsp'>ע��</a>��";
				request.setAttribute("message", message);
				return "false";
			}
		} else if (identity.equals("����")) {
			boolean isSuccess = managerService.login(id, password);
			if (isSuccess) {
				// ���session��cookie
				session.put("manager", id);
				Cookie cookie = new Cookie("manager", id);
				response.addCookie(cookie);

				return "manager";
			} else {
				message = "�û���������������������룡";
				request.setAttribute("message", message);
				return "false";
			}
		} else if (identity.equals("����Ա")) {
			boolean isSuccess = waiterService.login(id, password);
			if (isSuccess) {
				// ���session��cookie
				session.put("waiter", id);
				Cookie cookie = new Cookie("waiter", id);
				response.addCookie(cookie);

				return "waiter";
			} else {
				message = "���Ż�����������������룡";
				request.setAttribute("message", message);
				return "false";
			}
		} else {
			return "false";
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
