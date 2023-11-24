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
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(int affiliation) {
		this.affiliation = affiliation;
	}
	public int getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(int jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdministratorFlag() {
		return administratorFlag;
	}
	public void setAdministratorFlag(boolean administratorFlag) {
		this.administratorFlag = administratorFlag;
	}
}
