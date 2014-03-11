package nju.fraborna.healthclub.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import nju.fraborna.healthclub.dao.ActivityDao;
import nju.fraborna.healthclub.dao.CoachDao;
import nju.fraborna.healthclub.dao.WaiterDao;
import nju.fraborna.healthclub.dao.impl.ActivityDaoImpl;
import nju.fraborna.healthclub.dao.impl.CoachDaoImpl;
import nju.fraborna.healthclub.dao.impl.WaiterDaoImpl;
import nju.fraborna.healthclub.model.Activity;
import nju.fraborna.healthclub.model.Waiter;

public class WaiterService implements WaiterServiceInterface {

	private static WaiterService waiterService = new WaiterService();

	private WaiterDao waiterDaoImpl = WaiterDaoImpl.getInstance();
	private ActivityDao activityDaoImpl = ActivityDaoImpl.getInstance();
	private CoachDao coachDaoImpl = CoachDaoImpl.getInstance();

	private WaiterService() {
	}

	public static WaiterService getInstance() {
		return waiterService;
	}

	@Override
	public void recordMemberInActivity(String aid, String mid) {
		// TODO Auto-generated method stub
		activityDaoImpl.addActivityMember(aid, mid);
	}

	@Override
	public boolean login(String id, String password) {
		// TODO Auto-generated method stub
		Waiter waiter = waiterDaoImpl.getWaiterInfo(id);

		if (waiter != null)
			if (password.equals(waiter.getWpassword())) {
				return true;
			}

		return false;
	}

	@Override
	public void planActivity(String aid, String wid, String coachesID,
			String session, String date, String field) {
		// TODO Auto-generated method stub
		String[] coaches = coachesID.split("¡¢");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
		Date time = null;
		try {
			time = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < coaches.length; i++) {
			activityDaoImpl.addActivityCoach(aid, coaches[i]);
		}

		activityDaoImpl.addActivity(new Activity(aid, wid, new java.sql.Date(
				time.getTime()), field));
	}

	@Override
	public int getActivitiesNum() {
		// TODO Auto-generated method stub
		return activityDaoImpl.getActivitiesNum();
	}

	public String getActivitiesIDs() {
		String aids = "";

		String activities = activityDaoImpl.getActivities();
		String[] activity = activities.split("\\$");
		if (activity.length > 1) {
			for (int i = 0; i < activity.length; i++) {
				String[] activityAttr = activity[i].split("\\*");
				aids += activityAttr[0];
				aids += ",";
			}
			aids = aids.substring(0, aids.length() - 1);
		} else {
			String[] activityAttr = activities.split("\\*");
			aids += activityAttr[0];
			aids += ",";
		}

		return aids;
	}

	@Override
	public String getCoachesIDs() {
		// TODO Auto-generated method stub
		return coachDaoImpl.getAllCoachesIDs();
	}

}
