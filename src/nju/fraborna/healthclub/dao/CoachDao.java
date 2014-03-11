package nju.fraborna.healthclub.dao;

import nju.fraborna.healthclub.model.Coach;

public interface CoachDao {

	public boolean addCoach(Coach coach);
	
	public String getCoachesName(String aid);
	
	public String getAllCoachesIDs();
	
}
