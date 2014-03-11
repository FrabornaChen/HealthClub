package nju.fraborna.healthclub.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.fraborna.healthclub.dao.MemberDao;
import nju.fraborna.healthclub.model.Activity;
import nju.fraborna.healthclub.model.Member;
import nju.fraborna.healthclub.model.PayRecord;

public class MemberDaoImpl implements MemberDao {

	private DaoHelperImpl daoHelperImpl = DaoHelperImpl.getBaseDaoInstance();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private static MemberDaoImpl memberDaoImpl = new MemberDaoImpl();

	private MemberDaoImpl() {
		try {
			connection = daoHelperImpl.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MemberDaoImpl getInstance() {
		return memberDaoImpl;
	}

	@Override
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		String id = member.getMid();
		String password = member.getPassword();
		String name = member.getName();
		String sex = member.getSex();
		double age = member.getAge();
		String address = member.getAddress();
		String status = member.getStatus();

		String valueOfSql = "(\'" + id + "\',\'" + password + "\',\'" + name
				+ "\',\'" + age + "\',\'" + sex + "\',\'" + address + "\',\'"
				+ status + "\')";

		String sql = "insert into member values " + valueOfSql;

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Member getSingleMemberBaseInfo(String mid) {
		// TODO Auto-generated method stub
		Member member = null;
		String sql = "select * from member where mid = \'" + mid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				member = new Member(resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7));
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public ArrayList<Member> getFamilyMembersBaseInfo(String mid) {
		// TODO Auto-generated method stub
		ArrayList<Member> members = new ArrayList<>();
		Member member = null;
		String sql = "select * from member where mid = \'" + mid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				member = new Member(resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7));
				members.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return members;
	}

	@Override
	public ArrayList<Activity> getMemberEventsRecord(String mid) {
		// TODO Auto-generated method stub
		ArrayList<Activity> activityRecord = new ArrayList<>();
		String sql = "select a.aid, a.wid, a.date, a,field from activity a, activitymembers m where m.mid = \'"
				+ mid + "\' and m.aid = a.aid";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				activityRecord.add(new Activity(resultSet.getString(1),
						resultSet.getString(2), resultSet.getDate(3), resultSet
								.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return activityRecord;
	}

	@Override
	public ArrayList<PayRecord> getMemberPayRecord(String mid) {
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

	@Override
	public boolean modifyMemberBaseInfo(Member member) {
		// TODO Auto-generated method stub
		String sql = "";

		try {
			sql = "update member set mpassword = \'" + member.getPassword()
					+ "\', mname = \'" + member.getName() + "\', mage = "
					+ member.getAge() + ", msex = \'" + member.getSex()
					+ "\', maddress= \'" + member.getAddress() + "\'";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public int countMembers() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "select count(*) from member";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public void addLoginRecord(String id, Date date) {
		// TODO Auto-generated method stub
		String sql = "insert into memberloginrecord values (\'" + id + "\',\'"
				+ date + "\')";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@Override
	public void alterStatus(String id, String status) {
		// TODO Auto-generated method stub
		String sql = "update member set mstatus = \'" + status
				+ "\' where mid = \'" + id + "\'";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from member where mid = \'" + id + "\'";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Member> getAllMember() {
		// TODO Auto-generated method stub
		ArrayList<Member> members = new ArrayList<>();

		String sql = "select * from member";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				members.add(new Member(resultSet.getString(1), resultSet
						.getString(2), resultSet.getString(3), resultSet
						.getInt(4), resultSet.getString(5), resultSet
						.getString(6), resultSet.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return members;
	}

	@Override
	public double getICNum(String mid) {
		// TODO Auto-generated method stub
		double num = 0;

		String sql = "select * from balance where mid = \'" + mid + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				num = resultSet.getDouble(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num;
	}

	@Override
	public void addICNum(String id, double num) {
		// TODO Auto-generated method stub
		String sql = "update balance set num = " + num + "where mid = \'" + id
				+ "\'";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bindIC(String id, String ic) {
		// TODO Auto-generated method stub
		String sql = "insert into balance values (\'" + id + "\',\'" + ic
				+ "\',0, 0)";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteICNum(String id, double num) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "update balance set num = " + num + " where mid = \'" + id
				+ "\'";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setICStatus(String id, int status) {
		String sql = "update balance set status = " + status
				+ " where mid = \'" + id + "\'";

		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getICStatus(String id) {
		int i = 0;

		String sql = "select * from balance where mid = \'" + id + "\'";

		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				i = resultSet.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public void alterBaseInfo(String id, String name, String age, String sex,
			String address) {
		// TODO Auto-generated method stub
		String sql = "update member set mname = \'" + name + "\' , mage = \'"
				+ age + "\' , msex = \'" + sex + "\' , maddress = \'" + address
				+ "\' where mid = \'" + id +"\'";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
