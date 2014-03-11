package nju.fraborna.healthclub.dao;

import java.sql.Date;
import java.util.ArrayList;

import nju.fraborna.healthclub.model.PayRecord;

public interface PayRecordDao {

	public boolean addPayRecord(String mid,double payment,Date date);
	
	public String getPayRecord(String mid);
	
	public ArrayList<PayRecord> getPayRecords(String mid);
	
}
