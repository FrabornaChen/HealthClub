package nju.fraborna.healthclub.factory;

import nju.fraborna.healthclub.dao.ActivityDao;
import nju.fraborna.healthclub.dao.CoachDao;
import nju.fraborna.healthclub.dao.ManagerDao;
import nju.fraborna.healthclub.dao.MemberDao;
import nju.fraborna.healthclub.dao.PayRecordDao;
import nju.fraborna.healthclub.dao.WaiterDao;
import nju.fraborna.healthclub.dao.impl.ActivityDaoImpl;
import nju.fraborna.healthclub.dao.impl.CoachDaoImpl;
import nju.fraborna.healthclub.dao.impl.ManagerDaoImpl;
import nju.fraborna.healthclub.dao.impl.MemberDaoImpl;
import nju.fraborna.healthclub.dao.impl.PayRecordDaoImpl;
import nju.fraborna.healthclub.dao.impl.WaiterDaoImpl;

public class DaoFactory {

	public static ActivityDao getActivityDaoImplInstance() {
		return ActivityDaoImpl.getInstance();
	}

	public static CoachDao gCoachDaoImplInstance() {
		return CoachDaoImpl.getInstance();
	}

	public static ManagerDao getManagerDaoImplInstance() {
		return ManagerDaoImpl.getInstance();
	}

	public static MemberDao getMemberDaoImplInstance() {
		return MemberDaoImpl.getInstance();
	}

	public static PayRecordDao getPayRecordDaoImplInstance() {
		return PayRecordDaoImpl.getInstance();
	}

	public static WaiterDao getWaiterDaoImplInstance() {
		return WaiterDaoImpl.getInstance();
	}

}
