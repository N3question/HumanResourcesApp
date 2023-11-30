package model.map;

import java.util.HashMap;
import java.util.Map;

public class GenderMap {
	public static Map<Integer, String> genderMap = new HashMap<>();
	static {
		genderMap.put(1, "No answer");
		genderMap.put(2, "Female");
		genderMap.put(3, "Male");
	}
	
	public static String getGender(int gender) {
		return genderMap.get(gender);
	}
}
