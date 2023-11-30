package model.map;

import java.util.HashMap;
import java.util.Map;

public class JobTitleMap {
	public static Map<Integer, String> jobTitleMap = new HashMap<>();
	static {
		jobTitleMap.put(1, "No title");
		jobTitleMap.put(2, "Chief");
		jobTitleMap.put(3, "Section chief");
		jobTitleMap.put(4, "Section manager");
	}
	
	public static String getJobTitle(int jobTitle) {
		return jobTitleMap.get(jobTitle);
	}
}
