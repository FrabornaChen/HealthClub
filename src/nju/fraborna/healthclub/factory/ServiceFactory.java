package nju.fraborna.healthclub.factory;

import nju.fraborna.healthclub.service.ManagerService;
import nju.fraborna.healthclub.service.ManagerServiceInterface;
import nju.fraborna.healthclub.service.MemberService;
import nju.fraborna.healthclub.service.MemberServiceInterface;
import nju.fraborna.healthclub.service.WaiterService;
import nju.fraborna.healthclub.service.WaiterServiceInterface;

public class ServiceFactory {

	public static MemberServiceInterface getMemberServiceInstance() {
		return MemberService.getInstance();
	}

	public static ManagerServiceInterface getManagerServiceInstance() {
		return ManagerService.getInstance();
	}

	public static WaiterServiceInterface getWaiterServiceInstance() {
		return WaiterService.getInstance();
	}

}
