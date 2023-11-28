package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.db.ConnectionToDB;

class ConnectionToDBTest {

	@Test
	public void testConnToDB() {
		try {
			Connection conn = ConnectionToDB.getConnection();
			assertEquals(false, conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
