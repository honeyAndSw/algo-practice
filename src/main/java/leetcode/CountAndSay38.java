package leetcode;

/**
 * CountAndSay38
 */
public class CountAndSay38 {
	public String countAndSay(int n) {
		StringBuffer parent = new StringBuffer("1");
		int slow, fast;
		for (int i = 0; i < n - 1; i++) {
			slow = 0;
			fast = 0;

			StringBuffer sb = new StringBuffer();
			while (slow < parent.length() && fast <= parent.length()) {
				if (fast == parent.length() || parent.charAt(slow) != parent.charAt(fast)) {
					sb.append(fast - slow).append(parent.charAt(slow));
					slow = fast;
				}
				fast++;
			}

			parent = sb;
		}

		return parent.toString();
	}
}
