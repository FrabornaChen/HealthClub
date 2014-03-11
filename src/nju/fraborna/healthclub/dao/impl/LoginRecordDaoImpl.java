package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nju.fraborna.healthclub.dao.LoginRecordDao;

public class LoginRecordDaoImpl implements LoginRecordDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static LoginRecordDaoImpl loginRecordDaoImpl = new LoginRecordDaoImpl();

	private LoginRecordDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static LoginRecordDaoImpl getInstance() {
		return loginRecordDaoImpl;
	}

	@Override
	public int getDayLoginNum() {
		// TODO Auto-generated method stub
		int num = 0;
		String sql = "select count(*) from memberloginrecord where logintime = CURDATE()";

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

	@Override
	public int getMonthLoginNum() {
		// TODO Auto-generated method stub
		int num = 0;
		String sql = "select count(*) from memberloginrecord where logintime >= DATE_ADD(curdate(),interval -day(curdate())+1 day) and logintime < date_add(curdate()-day(curdate())+1,interval 1 month )";

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
