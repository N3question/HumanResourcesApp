package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.HumanResourcesBeans;

public class HumanResourcesDao {
	private final String URL = "jdbc:mysql://localhost/HR";
	private final String USER= "root";
	private final String PASSWORD = "";
	
	public ArrayList<HumanResourcesBeans> getHRAll() {
        ArrayList<HumanResourcesBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	String SQL = "SELECT * FROM human_resources_infos";
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                int gender = result.getInt("gender");
                int affiliation = result.getInt("affiliation");
                int jobTitle = result.getInt("job_title");
                int memberId = result.getInt("member_id");
                String password = result.getString("password");
                boolean administratorFlag = result.getBoolean("administrator_flag");
                
                HumanResourcesBeans HRBeans = new HumanResourcesBeans(id, name, email, gender, affiliation, jobTitle, memberId, password, administratorFlag);
     
                empList.add(HRBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
	
	public HumanResourcesBeans getHR(int HRid) {
		HumanResourcesBeans humanResourcesBeans = new HumanResourcesBeans();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	String SQL = "SELECT * FROM human_resources_infos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, HRid);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                int gender = result.getInt("gender");
                int affiliation = result.getInt("affiliation");
                int jobTitle = result.getInt("job_title");
                int memberId = result.getInt("member_id");
                
                humanResourcesBeans.setId(id);
                humanResourcesBeans.setName(name);
                humanResourcesBeans.setEmail(email);
                humanResourcesBeans.setGender(gender);
                humanResourcesBeans.setAffiliation(affiliation);
                humanResourcesBeans.setJobTitle(jobTitle);
            	humanResourcesBeans.setMemberId(memberId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return humanResourcesBeans;
    }
	
	public HumanResourcesBeans getUser(int memberId, String password) {
		HumanResourcesBeans humanResourcesBeans = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
        	String SQL = "SELECT * FROM human_resources_infos WHERE member_id = ? AND password = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, memberId);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	humanResourcesBeans = new HumanResourcesBeans();
            	int id = result.getInt("id");
            	int member_id = result.getInt("member_id");
            	// TODO nameはsessionの中から除外する
            	String name = result.getString("name");
            	humanResourcesBeans.setId(id);
            	humanResourcesBeans.setMemberId(member_id);
            	humanResourcesBeans.setName(name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return humanResourcesBeans;
    }

	public HumanResourcesBeans getUserInfo(int HRid) {
		HumanResourcesBeans humanResourcesBeans = new HumanResourcesBeans();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
        	String SQL = "SELECT * FROM human_resources_infos WHERE id = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, HRid);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	int id = result.getInt("id");
            	String name = result.getString("name");
            	String email = result.getString("email");
            	int gender = result.getInt("gender");
            	int affiliation = result.getInt("affiliation");
            	int job_title = result.getInt("job_title");
            	int member_id = result.getInt("member_id");
            	humanResourcesBeans.setId(id);
            	humanResourcesBeans.setName(name);
            	humanResourcesBeans.setEmail(email);
            	humanResourcesBeans.setGender(gender);
            	humanResourcesBeans.setAffiliation(affiliation);
            	humanResourcesBeans.setJobTitle(job_title);
            	humanResourcesBeans.setMemberId(member_id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return humanResourcesBeans;
    }
	
	public void updateUserInfo(String name, String email, int gender, int affiliation, int jobTitle, int HRid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
        	String SQL = "UPDATE human_resources_infos SET name = ?, email = ?, gender = ?, affiliation = ?, job_title = ? WHERE id = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, gender);
            statement.setInt(4, affiliation);
            statement.setInt(5, jobTitle);
            statement.setInt(6, HRid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public void insertUserInfo(int memberId, String name, String email, int gender, int affiliation, int jobTitle, boolean administratorFlag, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
        	String SQL = "INSERT INTO human_resources_infos (member_id, name, email, gender, affiliation, job_title, administrator_flag, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, memberId);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setInt(4, gender);
            statement.setInt(5, affiliation);
            statement.setInt(6, jobTitle);
            statement.setBoolean(7, administratorFlag);
            statement.setString(8, password);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public void deleteUserInfo(int HRid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	String SQL = "DELETE FROM human_resources_infos WHERE id = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, HRid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public ArrayList<Integer> getJobTitleAll() {
        ArrayList<Integer> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	String SQL = "SELECT job_title FROM human_resources_infos GROUP BY job_title";
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int jobTitle = result.getInt("job_title");
                empList.add(jobTitle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
	
	public ArrayList<Integer> getAffiliationAll() {
        ArrayList<Integer> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	String SQL = "SELECT affiliation FROM human_resources_infos GROUP BY affiliation";
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int affiliation = result.getInt("affiliation");
                empList.add(affiliation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
	
	public ArrayList<Integer> getGenderAll() {
        ArrayList<Integer> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	String SQL = "SELECT gender FROM human_resources_infos GROUP BY gender";
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                int gender = result.getInt("gender");
                empList.add(gender);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
}
