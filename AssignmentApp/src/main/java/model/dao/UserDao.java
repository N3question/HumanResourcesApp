package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.HumanResourcesBeans;
import model.db.ConnectionToDB;
import model.db.LoadJDBC;

public class UserDao {
	public HumanResourcesBeans select(int memberId, String password) {
		LoadJDBC.LoadingJDBC();
		HumanResourcesBeans HRBeans = null;
        try (Connection connection = ConnectionToDB.getConnection()) {
            
        	String SQL = "SELECT * FROM human_resources_infos WHERE member_id = ? AND password = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, memberId);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	HRBeans = new HumanResourcesBeans();
            	int id = result.getInt("id");
            	int member_id = result.getInt("member_id");
            	// TODO nameはsessionの中から除外する
            	String name = result.getString("name");
            	HRBeans.setId(id);
            	HRBeans.setMemberId(member_id);
            	HRBeans.setName(name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return HRBeans;
    }
}
