package model.map;

import java.util.HashMap;
import java.util.Map;

public class JobTitleMap {
	public static Map<Integer, String> jobTitleMap = new HashMap<>();
	static {
		jobTitleMap.put(0, "No title");
		jobTitleMap.put(1, "Chief");
		jobTitleMap.put(2, "Section chief");
		jobTitleMap.put(3, "Section manager");
	}
	
	public static String getJobTitle(int jobTitle) {
		return jobTitleMap.get(jobTitle);
	}
}
