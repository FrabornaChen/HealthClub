package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.fraborna.healthclub.dao.CoachDao;
import nju.fraborna.healthclub.model.Coach;

public class CoachDaoImpl implements CoachDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static CoachDaoImpl coachDaoImpl = new CoachDaoImpl();

	private CoachDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CoachDaoImpl getInstance() {
		return coachDaoImpl;
	}

	@Override
	public boolean addCoach(Coach coach) {
		// TODO Auto-generated method stub
		String sql = "insert into coach values (\'" + coach.getCid() + "\',\'"
				+ coach.getCname() + "\',\'" + coach.getCsex() + "\')";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// 返回某活动对应的教练姓名，形式如姓名A、姓名B、姓名C
	@Override
	public String getCoachesName(String aid) {
		// TODO Auto-generated method stub
		String coachesNames = "";
		ArrayList<String> cidList = new ArrayList<>();
		ArrayList<String> cnames = new ArrayList<>();

		String sql = "select * from activitycoaches where aid = \'" + aid
				+ "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cidList.add(resultSet.getString(2));
			}

			for (String id : cidList) {
				String sql2 = "select * from coach where cid = \'" + id + "\'";
				resultSet = statement.executeQuery(sql2);
				while (resultSet.next()) {
					cnames.add(resultSet.getString(2));
				}
			}

			for (String string : cnames) {
				coachesNames += string + "、";
			}
			if (coachesNames.length() > 0) {
				coachesNames = coachesNames.substring(0,
						coachesNames.length() - 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return coachesNames;
	}

	@Override
	public String getAllCoachesIDs() {
		// TODO Auto-generated method stub
		String ids = "";

		String sql = "select * from coach";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				ids += resultSet.getString(1);
				ids += ",";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ids = ids.substring(0, ids.length() - 1);

		return ids;
	}

}
