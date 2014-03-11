package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.fraborna.healthclub.dao.PayRecordDao;
import nju.fraborna.healthclub.model.PayRecord;

public class PayRecordDaoImpl implements PayRecordDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static PayRecordDaoImpl payRecordDaoImpl = new PayRecordDaoImpl();

	private PayRecordDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PayRecordDaoImpl getInstance() {
		return payRecordDaoImpl;
	}

	@Override
	public boolean addPayRecord(String mid, double payment, Date date) {
		// TODO Auto-generated method stub
		String sql = "insert into payrecord values (\'" + mid + "\',\'" + date
				+ "\',\'" + payment + "\')";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public String getPayRecord(String mid) {
		// TODO Auto-generated method stub
		String payRecordInfo = "";
		ArrayList<PayRecord> payRecords = new ArrayList<>();

		String sql = "select * from payrecord where mid = \'" + mid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				payRecords.add(new PayRecord(resultSet.getString(1), resultSet
						.getDate(2), resultSet.getDouble(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (PayRecord payRecord : payRecords) {
			payRecordInfo += payRecord.getDate() + "*" + payRecord.getMoney()
					+ "$";
		}

		if (payRecordInfo.length() > 1)
			payRecordInfo = payRecordInfo.substring(0,
					payRecordInfo.length() - 1);

		return payRecordInfo;
	}

	@Override
	public ArrayList<PayRecord> getPayRecords(String mid) {
		// TODO Auto-generated method stub
		ArrayList<PayRecord> payRecords = new ArrayList<>();

		String sql = "select * from payrecord where mid = \'" + mid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				payRecords.add(new PayRecord(resultSet.getString(1), resultSet
						.getDate(2), resultSet.getDouble(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return payRecords;
	}

}
