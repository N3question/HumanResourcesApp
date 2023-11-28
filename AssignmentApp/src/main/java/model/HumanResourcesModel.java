package model;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.bean.HumanResourcesBeans;
import model.dao.HumanResourcesDao;
import model.dao.MapDao;
import model.dao.UserDao;
import model.dao.UserInfoDao;
import model.hash.Hash;

public class HumanResourcesModel {
	public ArrayList<HumanResourcesBeans> HRSelectAll() {
		HumanResourcesDao HRDao = new HumanResourcesDao();
		ArrayList<HumanResourcesBeans> HRlist = HRDao.selectAll();
		return HRlist;
	}
	
	public void HRSelect(int id, HttpServletRequest request) {
		HumanResourcesDao HRDao = new HumanResourcesDao();
		HumanResourcesBeans HRinfo = HRDao.select(id);
		HttpSession session = request.getSession();
		session.setAttribute("HRinfo", HRinfo);
	}
	
	public void userSelect(int memberId, String password, HttpServletRequest request) {
		String hashedPassword = Hash.hashingPassword(password);
		// memberIdとhashedPasswordを使用してユーザ情報の取得
		UserDao userDao = new UserDao();
		HumanResourcesBeans sessionUserInfo = userDao.select(memberId, hashedPassword);
		
		// セッションの作成・取得 + set
		HttpSession session = request.getSession();
		session.setAttribute("sessionUserInfo", sessionUserInfo);
	}
	
	public HumanResourcesBeans userInfoSelect(int HRid) {
		UserInfoDao userInfoDao = new UserInfoDao();
		HumanResourcesBeans userInfo = userInfoDao.select(HRid);
		return userInfo;
	}
	
	public void userInfoUpdate(String name, String email, int gender, int affiliation, int jobTitle, int HRid) {
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.update(name, email, gender, affiliation, jobTitle, HRid);
	}
	
	public void userInfoInsert(int memberId, String name, String email, int gender, int affiliation, int jobTitle, boolean administratorFlag, String password) {
		String hashedPassword = Hash.hashingPassword(password);
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.insert(memberId, name, email, gender, affiliation, jobTitle, administratorFlag, hashedPassword);
	}
	
	public void deleteUserInfo(int HRid) {
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.delete(HRid);
	}
	
	public ArrayList<Integer> getJobTitleAll() {
		MapDao mapDao = new MapDao();
		ArrayList<Integer> jobTitle = mapDao.getJobTitleAll();
		return jobTitle;
	}
	
	public ArrayList<Integer> getAffiliationAll() {
		MapDao mapDao = new MapDao();
		ArrayList<Integer> affiliation = mapDao.getAffiliationAll();
		return affiliation;
	}
	
	public ArrayList<Integer> getGenderAll() {
		MapDao mapDao = new MapDao();
		ArrayList<Integer> gender = mapDao.getGenderAll();
		return gender;
	}
}
