package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nju.fraborna.healthclub.dao.WaiterDao;
import nju.fraborna.healthclub.model.Waiter;

public class WaiterDaoImpl implements WaiterDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static WaiterDaoImpl waiterDaoImpl = new WaiterDaoImpl();

	private WaiterDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WaiterDaoImpl getInstance() {
		return waiterDaoImpl;
	}

	@Override
	public Waiter getWaiterInfo(String wid) {
		// TODO Auto-generated method stub
		Waiter waiter = null;

		String sql = "select * from waiter where wid = \'" + wid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				waiter = new Waiter(resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return waiter;
	}

}
