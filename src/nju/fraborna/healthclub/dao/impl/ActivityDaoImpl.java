package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.fraborna.healthclub.dao.ActivityDao;
import nju.fraborna.healthclub.model.Activity;

public class ActivityDaoImpl implements ActivityDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static ActivityDaoImpl activityDaoImpl = new ActivityDaoImpl();

	private CoachDaoImpl coachDaoImpl = CoachDaoImpl.getInstance();

	private ActivityDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ActivityDaoImpl getInstance() {
		return activityDaoImpl;
	}

	@Override
	public boolean addActivity(Activity activity) {
		// TODO Auto-generated method stub
		String sql = "insert into activity values (\'" + activity.getAid()
				+ "\', \'" + activity.getWid() + "\', \'" + activity.getDate()
				+ "\', \'" + activity.getField() + "\')";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean addActivityCoach(String aid, String cid) {
		// TODO Auto-generated method stub
		String sql = "insert into activitycoaches values (\'" + aid + "\', \'"
				+ cid + "\')";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean addActivityMember(String aid, String mid) {
		// TODO Auto-generated method stub
		String sql = "insert into activitymembers values (\'" + aid + "\', \'"
				+ mid + "\')";
		boolean isSuccess = false;

		try {
			isSuccess = statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	@Override
	public Activity getActivityInfo(String aid) {
		// TODO Auto-generated method stub
		Activity activity = null;

		String sql = "select * from activity where aid = \'" + aid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			activity = new Activity(resultSet.getString(1),
					resultSet.getString(2), resultSet.getDate(3),
					resultSet.getString(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return activity;
	}

	@Override
	public boolean deleteMemberActivityRecord(String mid, String aid) {
		// TODO Auto-generated method stub
		String sql = "delete from activitymembers where aid = \'" + aid
				+ "\' and mid = \'" + mid;

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	// 返回活动信息，活动与活动之间用$符号间隔，活动内部属性之间用*符号间隔
	@Override
	public String getActivities() {
		// TODO Auto-generated method stub
		String activitiesInfo = "";
		ArrayList<Activity> activities = new ArrayList<>();
		ArrayList<String> activitiesID = new ArrayList<>();
		ArrayList<String> activityCoaches = new ArrayList<>();

		String sql = "select * from activity where date > now()";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Activity activity = new Activity(resultSet.getString(1),
						resultSet.getString(2), resultSet.getDate(3),
						resultSet.getString(4));
				activitiesID.add(resultSet.getString(1));
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (activities.size() > 0) {
			// 获得活动对应的教练名，教练名用，间隔
			for (String id : activitiesID) {
				activityCoaches.add(coachDaoImpl.getCoachesName(id));
			}

			for (int i = 0; i < activities.size(); i++) {
				Activity act = activities.get(i);
				activitiesInfo += act.getAid() + "*" + act.getField() + "*"
						+ act.getDate() + "*" + activityCoaches.get(i) + "$";
			}
		}

		return activitiesInfo;
	}

	// 返回活动信息，活动与活动之间用$符号间隔，活动内部属性之间用*符号间隔
	@Override
	public String getAllActivities() {
		// TODO Auto-generated method stub
		String activitiesInfo = "";
		ArrayList<Activity> activities = new ArrayList<>();
		ArrayList<String> activitiesID = new ArrayList<>();
		ArrayList<String> activityCoaches = new ArrayList<>();

		String sql = "select * from activity";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Activity activity = new Activity(resultSet.getString(1),
						resultSet.getString(2), resultSet.getDate(3),
						resultSet.getString(4));
				activitiesID.add(resultSet.getString(1));
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (activities.size() > 0) {
			// 获得活动对应的教练名，教练名用，间隔
			for (String id : activitiesID) {
				activityCoaches.add(coachDaoImpl.getCoachesName(id));
			}

			for (int i = 0; i < activities.size(); i++) {
				Activity act = activities.get(i);
				activitiesInfo += act.getAid() + "*" + act.getField() + "*"
						+ act.getDate() + "*" + activityCoaches.get(i) + "$";
			}

			activitiesInfo = activitiesInfo.substring(0,
					activitiesInfo.length() - 1);
		}

		return activitiesInfo;
	}

	@Override
	public String getActivityRecord(String id) {
		// TODO Auto-generated method stub
		ArrayList<String> aidList = new ArrayList<>();
		ArrayList<Activity> activities = new ArrayList<>();
		ArrayList<String> activitiesID = new ArrayList<>();
		ArrayList<String> activityCoaches = new ArrayList<>();

		String activitiesInfo = "";

		String sql = "select * from activitymembers where mid = \'" + id + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				aidList.add(resultSet.getString(1));
			}

			for (int i = 0; i < aidList.size(); i++) {
				String sql2 = "select * from activity where aid = \'"
						+ aidList.get(i) + "\'";

				resultSet = statement.executeQuery(sql2);

				while (resultSet.next()) {
					Activity activity = new Activity(resultSet.getString(1),
							resultSet.getString(2), resultSet.getDate(3),
							resultSet.getString(4));
					activitiesID.add(resultSet.getString(1));
					activities.add(activity);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (activities.size() > 0) {
			// 获得活动对应的教练名，教练名用？间隔
			for (String cid : activitiesID) {
				activityCoaches.add(coachDaoImpl.getCoachesName(cid));
			}

			for (int i = 0; i < activities.size(); i++) {
				Activity act = activities.get(i);
				activitiesInfo += act.getAid() + "*" + act.getField() + "*"
						+ act.getDate() + "*" + activityCoaches.get(i) + "$";
			}

			activitiesInfo = activitiesInfo.substring(0,
					activitiesInfo.length() - 1);
		}

		return activitiesInfo;
	}

	@Override
	public int getActivitiesNum() {
		// TODO Auto-generated method stub
		int num = 0;

		String sql = "select count(*) from activity";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				num = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num;
	}
}
