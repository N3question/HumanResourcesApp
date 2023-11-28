package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.db.LoadJDBC;

class LoadJDBCTest {

	@Test
	public void testLoadJDBC() {
		String message = LoadJDBC.LoadingJDBC();
		assertEquals("JDBCドライバの読み込みに成功しました", message);
	}
}
