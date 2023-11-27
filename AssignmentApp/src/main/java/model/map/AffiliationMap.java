package model.map;

import java.util.HashMap;
import java.util.Map;

public class AffiliationMap {
	public static Map<Integer, String> affiliationMap = new HashMap<>();
	static {
		affiliationMap.put(0, "Legal Deaprtment");
		affiliationMap.put(1, "Accounting Department");
		affiliationMap.put(2, "Marketing Department");
		affiliationMap.put(3, "Public Relations Department");
		affiliationMap.put(4, "Business Department");
		affiliationMap.put(5, "Human Resources Division");
	}
	
	public static String getAffiliation(int affiliation) {
		return affiliationMap.get(affiliation);
	}
}
