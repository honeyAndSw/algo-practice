package leetcode;

import java.util.*;

public class GroupAnagrams49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String key = sort(s);
			List<String> value = map.containsKey(key)
								? map.get(key) : new LinkedList<>();
			value.add(s);
			map.put(key, value);
		}

		List<List<String>> result = new LinkedList<>();
		result.addAll(map.values());
		return result;
	}

	private String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
