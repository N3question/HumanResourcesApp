package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.bean.HumanResourcesBeans;
import model.dao.UserDao;

class UserDaoTest {

	@Test
	void testSelectId() {
		UserDao userDao = new UserDao();
		HumanResourcesBeans userInfo = userDao.select(14371142, "e85130791f31db1699f61a5e7ae7b5e85e70399414f38476091896214771cd17");
		assertEquals(4, userInfo.getId());
		assertEquals(14371142, userInfo.getMemberId());
		assertEquals("Sky Bass", userInfo.getName());
	}
}
