package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.db.ConnectionToDB;
import model.db.LoadJDBC;

public class MapDao {
	public ArrayList<Integer> getJobTitleAll() {
		LoadJDBC.LoadingJDBC();
        ArrayList<Integer> empList = new ArrayList<>();
        try (Connection connection = ConnectionToDB.getConnection()) {
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
		LoadJDBC.LoadingJDBC();
        ArrayList<Integer> empList = new ArrayList<>();
        try (Connection connection = ConnectionToDB.getConnection()) {
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
		LoadJDBC.LoadingJDBC();
		ArrayList<Integer> empList = new ArrayList<>();
        try (Connection connection = ConnectionToDB.getConnection()) {
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
