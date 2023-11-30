package model.map;

import java.util.HashMap;
import java.util.Map;

public class AffiliationMap {
	public static Map<Integer, String> affiliationMap = new HashMap<>();
	static {
		affiliationMap.put(1, "Legal Deaprtment");
		affiliationMap.put(2, "Accounting Department");
		affiliationMap.put(3, "Marketing Department");
		affiliationMap.put(4, "Public Relations Department");
		affiliationMap.put(5, "Business Department");
		affiliationMap.put(6, "Human Resources Division");
	}
	
	public static String getAffiliation(int affiliation) {
		return affiliationMap.get(affiliation);
	}
}
