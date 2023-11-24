package model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.bean.HumanResourcesBeans;
import model.dao.HumanResourcesDao;
import model.utils.HashGenerator;

public class HumanResourcesModel {
	public ArrayList<HumanResourcesBeans> HRSelectAll() {
		HumanResourcesDao HRDao = new HumanResourcesDao();
		ArrayList<HumanResourcesBeans> HRlist = HRDao.getHRAll();
		return HRlist;
	}
	
	public void HRSelect(int id, HttpServletRequest request) {
		HumanResourcesDao HRDao = new HumanResourcesDao();
		HumanResourcesBeans HRinfo = HRDao.getHR(id);
		HttpSession session = request.getSession();
		session.setAttribute("HRinfo", HRinfo);
	}
	
	public void userSelect(int memberId, String password, HttpServletRequest request) {
		String hashedPassword = "";
		try {
			// passwordをハッシュ化
			hashedPassword = HashGenerator.generateHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// memberIdとhashedPasswordを使用してユーザ情報の取得
		HumanResourcesDao humanResourcesDao = new HumanResourcesDao();
		HumanResourcesBeans sessionUserInfo = humanResourcesDao.getUser(memberId, hashedPassword);
		
		// セッションの作成・取得 + set
		HttpSession session = request.getSession();
		session.setAttribute("sessionUserInfo", sessionUserInfo);
	}
	
	public HumanResourcesBeans userInfoSelect(int HRid) {
		HumanResourcesDao humanResourcesDao = new HumanResourcesDao();
		HumanResourcesBeans userInfo = humanResourcesDao.getUserInfo(HRid);
		return userInfo;
	}
	
	public void userInfoUpdate(String name, String email, int gender, int affiliation, int jobTitle, int HRid) {
		HumanResourcesDao humanResourcesDao = new HumanResourcesDao();
		humanResourcesDao.updateUserInfo(name, email, gender, affiliation, jobTitle, HRid);
	}
	
	public void userInfoInsert(int memberId, String name, String email, int gender, int affiliation, int jobTitle, boolean administratorFlag, String password) {
		String hashedPassword = "";
		try {
			// passwordをハッシュ化
			hashedPassword = HashGenerator.generateHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		HumanResourcesDao humanResourcesDao = new HumanResourcesDao();
		humanResourcesDao.insertUserInfo(memberId, name, email, gender, affiliation, jobTitle, administratorFlag, hashedPassword);
	}
	
	public void deleteUserInfo(int HRid) {
		HumanResourcesDao humanResourcesDao = new HumanResourcesDao();
		humanResourcesDao.deleteUserInfo(HRid);
	}
}
