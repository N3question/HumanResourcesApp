package model.map;

import java.util.HashMap;
import java.util.Map;

public class GenderMap {
	public static Map<Integer, String> genderMap = new HashMap<>();
	static {
		genderMap.put(0, "No answer");
		genderMap.put(1, "Female");
		genderMap.put(2, "Male");
	}
	
	public static String getGender(int gender) {
		return genderMap.get(gender);
	}
}
