package nju.fraborna.healthclub.service;

import java.util.Map;

public interface ManagerServiceInterface {
	
	public boolean login(String name, String password);

	public String getMembersByAge();
	
	public String getMemberBySex();
	
	public String getMemberByStatus();
	
	public String getMemberByAddress();
	
	public String getInfoAboutField();
	
	public String getInfoAboutCoach();

	public int getDayLoginNum();

	public int getMonthLoginNum();

	public Map<String, Integer> getFieldCondition();

	public Map<String, Integer> getCoachCondition();
	
}
