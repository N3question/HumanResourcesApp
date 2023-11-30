package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.bean.HumanResourcesBeans;
import model.dao.UserInfoDao;

class UserInfoDaoTest {
	// FIXME 以下DBの値を修正したので変更が必要
	@Test
	public void testSelect() {
		UserInfoDao userInfoDao = new UserInfoDao();
		HumanResourcesBeans userInfo = userInfoDao.select(2);
		assertEquals(2, userInfo.getId());
		assertEquals("Edwards-Blake Sweet", userInfo.getName());
		assertEquals("sample@gmail.com", userInfo.getEmail());
		assertEquals(1, userInfo.getGender());
		assertEquals(2, userInfo.getAffiliation());
		assertEquals(4, userInfo.getJobTitle());
		assertEquals(74185585, userInfo.getMemberId());
	}
	
	@Test
	public void testInsert() {
		UserInfoDao userInfoDao = new UserInfoDao();
		String message = userInfoDao.insert(80184356, "Brianna Rixon", "sample@gmail.com", 0, 3, 2, false, "e85130791f31db1699f61a5e7ae7b5e85e70399414f38476091896214771cd17");
		assertEquals("INSERTが成功しました", message);
	}
	
	@Test
	public void testInsertFalse1() {
		UserInfoDao userInfoDao = new UserInfoDao();
		String message = userInfoDao.insert(80184356, "Brianna Rixon", "sample@gmail.com", 0, 3, 2, false, "e85130791f31db1699f61a5e7ae7b5e85e70399414f38476091896214771cd17");
		assertEquals("INSERTが失敗しました", message);
	}
	
	// FIXME nullではなく空文字になっているため、処理が走ってしまう
	@Test
	public void testInsertFalse2() {
		UserInfoDao userInfoDao = new UserInfoDao();
		String message = userInfoDao.insert(31753675, null, "sample@gmail.com", 0, 3, 2, false, null);
		assertEquals("INSERTが失敗しました", message);
	}
	
	@Test
	public void testUpdate() {
		UserInfoDao userInfoDao = new UserInfoDao();
		int updateNum = userInfoDao.update("Rhett Veal", "sample@gmail.com", 2, 1, 1, 6);
		assertEquals(1, updateNum);
	}
	
	@Test
	public void testUpdateFalse() {
		UserInfoDao userInfoDao = new UserInfoDao();
		int updateNum = userInfoDao.update("Johanna MacGill", "sample1@gmail.com", 1, 1, 1, 99);
		assertEquals(0, updateNum);
	}
	
	@Test
	public void testDelete() {
		UserInfoDao userInfoDao = new UserInfoDao();
		int deleteNum = userInfoDao.delete(17);
		assertEquals(1, deleteNum);
	}
	
	@Test
	public void testDeleteFalse() {
		UserInfoDao userInfoDao = new UserInfoDao();
		int deleteNum = userInfoDao.delete(15);
		assertEquals(0, deleteNum);
	}
}
