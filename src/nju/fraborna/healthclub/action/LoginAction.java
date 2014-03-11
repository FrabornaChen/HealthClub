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
			message = "请将卡号和密码填写完整！";
			request.setAttribute("message", message);
			return "false";
		}

		if (identity.equals("会员")) {
			String isSuccess = memberService.loginin(id, password);
			if (isSuccess.equals("ok")) {
				memberService.addLoginRecord(id);

				// 添加session和cookie
				session.put("memberId", id);
				Cookie cookie = new Cookie("memberId", id);
				response.addCookie(cookie);

				return "success";
			} else if (isSuccess.equals("wrong")) {
				message = "卡号或密码错误，请重新输入！";
				request.setAttribute("message", message);
				return "false";
			} else {
				message = "会员资格已注销！请重新<a href='register.jsp'>注册</a>！";
				request.setAttribute("message", message);
				return "false";
			}
		} else if (identity.equals("经理")) {
			boolean isSuccess = managerService.login(id, password);
			if (isSuccess) {
				// 添加session和cookie
				session.put("manager", id);
				Cookie cookie = new Cookie("manager", id);
				response.addCookie(cookie);

				return "manager";
			} else {
				message = "用户名或密码错误，请重新输入！";
				request.setAttribute("message", message);
				return "false";
			}
		} else if (identity.equals("服务员")) {
			boolean isSuccess = waiterService.login(id, password);
			if (isSuccess) {
				// 添加session和cookie
				session.put("waiter", id);
				Cookie cookie = new Cookie("waiter", id);
				response.addCookie(cookie);

				return "waiter";
			} else {
				message = "卡号或密码错误，请重新输入！";
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
