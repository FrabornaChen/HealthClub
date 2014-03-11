package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nju.fraborna.healthclub.dao.ManagerDao;
import nju.fraborna.healthclub.model.Manager;

public class ManagerDaoImpl implements ManagerDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();

	private ManagerDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ManagerDaoImpl getInstance() {
		return managerDaoImpl;
	}

	@Override
	public Manager getManager(String name) {
		// TODO Auto-generated method stub
		Manager manager = null;

		String sql = "select * from manager where name = \'" + name + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				manager = new Manager(resultSet.getString(1),
						resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return manager;
	}

}
