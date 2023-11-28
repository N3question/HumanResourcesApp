package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.bean.HumanResourcesBeans;
import model.dao.HumanResourcesDao;

class HumanResourcesDaoTest {

	@Test
	public void testSelectAll() {
		HumanResourcesDao HRDao = new HumanResourcesDao();
		ArrayList<HumanResourcesBeans> HRlist = HRDao.selectAll();
		assertEquals(6, HRlist.size());
	}
	
	@Test
	public void testSelect() {
		HumanResourcesDao HRDao = new HumanResourcesDao();
		HumanResourcesBeans HR = HRDao.select(3);
		assertEquals(69141744, HR.getMemberId());
	}
}
