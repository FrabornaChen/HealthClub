package nju.fraborna.healthclub.dao;

import nju.fraborna.healthclub.model.Activity;

public interface ActivityDao {
	
	public boolean addActivity(Activity activity);
	
	public boolean addActivityCoach(String aid, String cid);
	
	public boolean addActivityMember(String aid, String mid);
	
	public Activity getActivityInfo(String aid);
	
	public boolean deleteMemberActivityRecord(String mid,String aid);
	
	public String getActivities();
	
	public int getActivitiesNum();
	
	public String getAllActivities();
	
	public String getActivityRecord(String id);
	
}
