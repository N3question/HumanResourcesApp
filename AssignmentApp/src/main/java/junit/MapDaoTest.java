package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.map.AffiliationMap;
import model.map.GenderMap;
import model.map.JobTitleMap;

class MapDaoTest {

	@Test
	public void testAffiliationMap() {
		// staticの修飾子をつけているからnewしなくていい
		// AffiliationMap AFM = new AffiliationMap();
		String result = AffiliationMap.getAffiliation(4);
		assertEquals("Public Relations Department", result);
	}
	
	@Test
	void testGenderMap() {
		String result = GenderMap.getGender(3);
		assertEquals("Male", result);
	}
	
	@Test
	void testJobTitleMap() {
		String result = JobTitleMap.getJobTitle(1);
		assertEquals("No title", result);
	}
}
