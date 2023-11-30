package model.bean;

import java.io.Serializable;

public class HumanResourcesBeans implements Serializable {
	private int id;
	private String name;
	private String email;
	private int gender;
	private int affiliation;
	private int jobTitle;
	private int memberId;
	private String password;
	private boolean administratorFlag;
	
	public HumanResourcesBeans() {}
	public HumanResourcesBeans(int id, String name, String email, int gender, int affiliation, int jobTitle, int memberId, String password, boolean administratorFlag) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.affiliation = affiliation;
		this.jobTitle = jobTitle;
		this.memberId = memberId;
		this.password = password;
		this.administratorFlag = administratorFlag;
 	}
	public HumanResourcesBeans(String name, String email, int gender, int affiliation, int jobTitle, int memberId, String password, boolean administratorFlag) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.affiliation = affiliation;
		this.jobTitle = jobTitle;
		this.memberId = memberId;
		this.password = password;
		this.administratorFlag = administratorFlag;
 	}
	public HumanResourcesBeans(int jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		// TODO null判定の機能追加途中
		if (!name.equals("") && name != null && name.length() > 0) {
			this.name = name;
		} else {
			this.name = null;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (!email.equals("") && email != null && email.length() > 0) {
			this.email = email;
		} else {
			this.email = null;
		}
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		if (gender != 0 && gender < 4) {
			this.gender = gender;
		} else {
			this.gender = 0;
		}
	}
	public int getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(int affiliation) {
		if (affiliation != 0 && affiliation < 7) {
			this.affiliation = affiliation;
		} else {
			this.affiliation = 0;
		}
	}
	public int getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(int jobTitle) {
		if (jobTitle != 0 && jobTitle < 5) {
			this.jobTitle = jobTitle;
		} else {
			this.jobTitle = 0;
		}
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		if (String.valueOf(memberId).length() == 8) {
			this.memberId = memberId;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if (!password.equals("") && password != null && password.length() > 0) {
			this.password = password;
		} else {
			this.password = null;
		}
	}
	public boolean isAdministratorFlag() {
		return administratorFlag;
	}
	public void setAdministratorFlag(boolean administratorFlag) {
		this.administratorFlag = administratorFlag;
	}
}
