package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.HumanResourcesBeans;
import model.db.ConnectionToDB;
import model.db.LoadJDBC;

public class HumanResourcesDao {
	
	public ArrayList<HumanResourcesBeans> selectAll() {
        LoadJDBC.LoadingJDBC();
        ArrayList<HumanResourcesBeans> empList = new ArrayList<>();
        try (Connection connection = ConnectionToDB.getConnection()) {
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
	
	public HumanResourcesBeans select(int HRid) {
		LoadJDBC.LoadingJDBC();
		HumanResourcesBeans HRBeans = new HumanResourcesBeans();
        try (Connection connection = ConnectionToDB.getConnection()) {
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
                
                HRBeans.setId(id);
                HRBeans.setName(name);
                HRBeans.setEmail(email);
                HRBeans.setGender(gender);
                HRBeans.setAffiliation(affiliation);
                HRBeans.setJobTitle(jobTitle);
                HRBeans.setMemberId(memberId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return HRBeans;
    }
}
