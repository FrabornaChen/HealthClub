package nju.fraborna.healthclub.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import nju.fraborna.healthclub.dao.ActivityDao;
import nju.fraborna.healthclub.dao.LoginRecordDao;
import nju.fraborna.healthclub.dao.ManagerDao;
import nju.fraborna.healthclub.dao.MemberDao;
import nju.fraborna.healthclub.dao.impl.ActivityDaoImpl;
import nju.fraborna.healthclub.dao.impl.LoginRecordDaoImpl;
import nju.fraborna.healthclub.dao.impl.ManagerDaoImpl;
import nju.fraborna.healthclub.dao.impl.MemberDaoImpl;
import nju.fraborna.healthclub.model.Manager;
import nju.fraborna.healthclub.model.Member;
import nju.fraborna.healthclub.model.MemberStatus;

public class ManagerService implements ManagerServiceInterface {

	private static ManagerService managerService = new ManagerService();

	private ManagerDao managerDaoImpl = ManagerDaoImpl.getInstance();
	private MemberDao memberDaoImpl = MemberDaoImpl.getInstance();
	private ActivityDao activityDaoImpl = ActivityDaoImpl.getInstance();
	private LoginRecordDao loginRecordDaoImpl = LoginRecordDaoImpl
			.getInstance();

	private ManagerService() {

	}

	public static ManagerService getInstance() {
		return managerService;
	}

	@Override
	public int getDayLoginNum() {
		// TODO Auto-generated method stub
		return loginRecordDaoImpl.getDayLoginNum();
	}

	@Override
	public int getMonthLoginNum() {
		// TODO Auto-generated method stub
		return loginRecordDaoImpl.getMonthLoginNum();
	}

	@Override
	public Map<String, Integer> getFieldCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getCoachCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		Manager manager = managerDaoImpl.getManager(name);

		if (manager != null) {
			if (manager.getMpassword().equals(password)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String getMembersByAge() {
		// TODO Auto-generated method stub
		String byage = "";
		ArrayList<Member> members = memberDaoImpl.getAllMember();
		int numbelow20 = 0;
		int num30 = 0;
		int num40 = 0;
		int num50 = 0;
		int numover50 = 0;

		for (Member member : members) {
			int age = member.getAge();
			if (age <= 20) {
				numbelow20++;
			} else if (age <= 30) {
				num30++;
			} else if (age <= 40) {
				num40++;
			} else if (age <= 50) {
				num50++;
			} else {
				numover50++;
			}
		}

		byage += numbelow20 + "," + num30 + "," + num40 + "," + num50 + ","
				+ numover50;

		return byage;
	}

	public String getMemberBySex() {
		String numBySex = "";
		ArrayList<Member> members = memberDaoImpl.getAllMember();
		int maleNum = 0;
		int femaleNum = 0;

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getSex().equals("男"))
				maleNum++;
			else if (members.get(i).getSex().equals("女"))
				femaleNum++;
		}

		numBySex = maleNum + "," + femaleNum;

		return numBySex;
	}

	@Override
	public String getMemberByStatus() {
		// TODO Auto-generated method stub
		String numByStatus = "";
		ArrayList<Member> members = memberDaoImpl.getAllMember();
		int nonactivate = 0;
		int normal = 0;
		int suspend = 0;
		int stop = 0;
		int cancel = 0;

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getStatus()
					.equals(MemberStatus.NORMAL.toString()))
				normal++;
			else if (members.get(i).getStatus()
					.equals(MemberStatus.SUSPEND.toString()))
				suspend++;
			else if (members.get(i).getStatus()
					.equals(MemberStatus.STOP.toString()))
				stop++;
			else if (members.get(i).getStatus()
					.equals(MemberStatus.CANCEL.toString()))
				cancel++;
			else if (members.get(i).getStatus()
					.equals(MemberStatus.NONACTIVATE.toString()))
				nonactivate++;
		}

		numByStatus = nonactivate + "," + normal + "," + suspend + "," + stop
				+ "," + cancel;

		return numByStatus;
	}

	@Override
	public String getMemberByAddress() {
		// TODO Auto-generated method stub
		String numByAddress = "";
		ArrayList<Member> members = memberDaoImpl.getAllMember();
		int beijing = 0;
		int tianjin = 0;
		int shanghai = 0;
		int chognqing = 0;
		int hebei = 0;
		int shanxi = 0;
		int neimenggu = 0;
		int liaoning = 0;
		int jilin = 0;
		int heilongjiang = 0;
		int jiangsu = 0;
		int zhejiang = 0;
		int anhui = 0;
		int fujian = 0;
		int jiangxi = 0;
		int shandong = 0;
		int henan = 0;
		int hubei = 0;
		int hunan = 0;
		int guangdong = 0;
		int guangxi = 0;
		int hainan = 0;
		int sichuan = 0;
		int guizhou = 0;
		int yunnan = 0;
		int xizang = 0;
		int shanxisheng = 0;
		int gansu = 0;
		int qinghai = 0;
		int ningxia = 0;
		int xinjiang = 0;
		int xianggang = 0;
		int aomen = 0;
		int taiwan = 0;

		for (int i = 0; i < members.size(); i++) {
			switch (members.get(i).getAddress().split("/")[0]) {
			case "北京市":
				beijing++;
				break;
			case "天津市":
				tianjin++;
				break;
			case "上海市":
				shanghai++;
				break;
			case "重庆市":
				chognqing++;
				break;
			case "河北省":
				hebei++;
				break;
			case "山西省":
				shanxi++;
				break;
			case "内蒙古":
				neimenggu++;
				break;
			case "辽宁省":
				liaoning++;
				break;
			case "吉林省":
				jilin++;
				break;
			case "黑龙江省":
				heilongjiang++;
				break;
			case "江苏省":
				jiangsu++;
				break;
			case "浙江省":
				zhejiang++;
				break;
			case "安徽省":
				anhui++;
				break;
			case "福建省":
				fujian++;
				break;
			case "江西省":
				jiangxi++;
				break;
			case "山东省":
				shandong++;
				break;
			case "河南省":
				henan++;
				break;
			case "湖北省":
				hubei++;
				break;
			case "湖南省":
				hunan++;
				break;
			case "广东省":
				guangdong++;
				break;
			case "广西":
				guangxi++;
				break;
			case "海南省":
				hainan++;
				break;
			case "四川省":
				sichuan++;
				break;
			case "贵州省":
				guizhou++;
				break;
			case "云南省":
				yunnan++;
				break;
			case "西藏":
				xizang++;
				break;
			case "陕西省":
				shanxisheng++;
				break;
			case "甘肃省":
				gansu++;
				break;
			case "青海省":
				qinghai++;
				break;
			case "宁夏":
				ningxia++;
				break;
			case "新疆":
				xinjiang++;
				break;
			case "香港":
				xianggang++;
				break;
			case "澳门":
				aomen++;
				break;
			case "台湾省":
				taiwan++;
				break;
			default:
				break;
			}
		}

		numByAddress = beijing + "," + tianjin + "," + shanghai + ","
				+ chognqing + "," + hebei + "," + shanxi + "," + neimenggu
				+ "," + liaoning + "," + jilin + "," + heilongjiang + ","
				+ jiangsu + "," + zhejiang + "," + anhui + "," + fujian + ","
				+ jiangxi + "," + shandong + "," + henan + "," + hubei + ","
				+ hunan + "," + guangdong + "," + guangxi + "," + hainan + ","
				+ sichuan + "," + guizhou + "," + yunnan + "," + xizang + ","
				+ shanxisheng + "," + gansu + "," + qinghai + "," + ningxia
				+ "," + xinjiang + "," + xianggang + "," + aomen + "," + taiwan;

		return numByAddress;
	}

	@Override
	public String getInfoAboutField() {
		// TODO Auto-generated method stub
		String fieldInfo = "";
		Set<String> fields = new HashSet<>();

		String[] activities = activityDaoImpl.getAllActivities().split("\\$");

		for (String activity : activities) {
			String[] attr = activity.split("\\*");
			fields.add(attr[1]);
		}

		for (String field : fields) {
			fieldInfo += field + "?";
			for (String activity : activities) {
				if (activity.split("\\*")[1].equals(field)) {
					fieldInfo += activity + "&";
				}
			}
			if (fieldInfo.length() > 0) {
				fieldInfo = fieldInfo.substring(0, fieldInfo.length() - 1);
				fieldInfo += "$";
			}
		}

		if (fieldInfo.length() > 0) {
			fieldInfo = fieldInfo.substring(0, fieldInfo.length() - 1);
		}

		return fieldInfo;
	}

	@Override
	public String getInfoAboutCoach() {
		// TODO Auto-generated method stub
		String coachInfo = "";
		Set<String> coaches = new HashSet<>();

		String[] activities = activityDaoImpl.getAllActivities().split("\\$");

		for (String activity : activities) {
			String[] attr = activity.split("\\*");
			String coach = attr[3];
			String[] multicoaches = coach.split("、");
			for (String string : multicoaches) {
				coaches.add(string);
			}
		}

		for (String coach : coaches) {
			coachInfo += coach + "?";
			for (String activity : activities) {
				if (activity.split("\\*")[3].contains(coach)) {
					coachInfo += activity + "&";
				}
			}
			if (coachInfo.length() > 0) {
				coachInfo = coachInfo.substring(0, coachInfo.length() - 1);
				coachInfo += "$";
			}
		}

		if (coachInfo.length() > 0) {
			coachInfo = coachInfo.substring(0, coachInfo.length() - 1);
		}

		return coachInfo;
	}
}
