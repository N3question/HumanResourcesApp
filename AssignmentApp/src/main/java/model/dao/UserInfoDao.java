package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.HumanResourcesBeans;
import model.db.ConnectionToDB;
import model.db.LoadJDBC;

public class UserInfoDao {
	public HumanResourcesBeans select(int HRid) {
		LoadJDBC.LoadingJDBC();
		HumanResourcesBeans HRBeans = new HumanResourcesBeans();
        try (Connection connection = ConnectionToDB.getConnection()) {
            
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
            	HRBeans.setId(id);
            	HRBeans.setName(name);
            	HRBeans.setEmail(email);
            	HRBeans.setGender(gender);
            	HRBeans.setAffiliation(affiliation);
            	HRBeans.setJobTitle(job_title);
            	HRBeans.setMemberId(member_id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return HRBeans;
    }
	
	public String insert(int memberId, String name, String email, int gender, int affiliation, int jobTitle, boolean administratorFlag, String password) {
		String message = "";
		LoadJDBC.LoadingJDBC();
		try (Connection connection = ConnectionToDB.getConnection()) {
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
			message = "INSERTが成功しました";
		} catch (SQLException ex) {
			ex.printStackTrace();
			message = "INSERTが失敗しました";
		}
		return message;
	}
	
	public int update(String name, String email, int gender, int affiliation, int jobTitle, int HRid) {
		int updateNum = 0;
		LoadJDBC.LoadingJDBC();
        try (Connection connection = ConnectionToDB.getConnection()) {
        	String SQL = "UPDATE human_resources_infos SET name = ?, email = ?, gender = ?, affiliation = ?, job_title = ? WHERE id = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, gender);
            statement.setInt(4, affiliation);
            statement.setInt(5, jobTitle);
            statement.setInt(6, HRid);
            updateNum = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return updateNum;
    }
	
	public int delete(int HRid) {
		int deleteNum = 0;
		LoadJDBC.LoadingJDBC();
        try (Connection connection = ConnectionToDB.getConnection()) {
        	String SQL = "DELETE FROM human_resources_infos WHERE id = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, HRid);
            deleteNum = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return deleteNum;
    }
}
