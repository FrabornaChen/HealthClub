package nju.fraborna.healthclub.service;

public interface WaiterServiceInterface {

	public void planActivity(String aid, String wid, String coachesID, String session, String date,
			String field);

	public void recordMemberInActivity(String aid, String mid);
	
	public boolean login(String id, String password);
	
	public int getActivitiesNum();

	public String getActivitiesIDs();
	
	public String getCoachesIDs();
}
