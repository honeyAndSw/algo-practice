package algostrategies.dptechnique09;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Dragon
 */
public class Dragon {
	static HashMap<String, String> cache0 = new HashMap<>();

	// When evolveCache's type is int:
	// 29 = 1610612734
	// 30 = -1073741826
	// 31 = 2147483646
	// 32 = -2
	// 34 = -2
	static long[] evolveCache = new long[51];

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		setEvolveCache();
		for (int c = 0; c < cases; c++) {
			int gen = sc.nextInt();
			int skip = sc.nextInt();
			int len = sc.nextInt();
			System.out.println(dragon(gen, skip - 1, len));
		}
	}

	public static void setEvolveCache() {
		evolveCache[0] = 1;
		for (int i = 1; i < evolveCache.length; i++) {
			evolveCache[i] = 2 * evolveCache[i - 1] + 2;
		}
	}

	public static String dragon(int generations, int skip, int len) {
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			sb.append(dragon("FX", generations, skip + i));
		}
		return sb.toString();
	}

	/**
	 * @param seed seed string to be evolved if needed.
	 * @param generations the number of evolution need to do.
	 * @param skip
	 * @return
	 */
	public static char dragon(String seed, int generations, int skip) {
		if (generations == 0) {
			return seed.charAt(skip);
		}

		for (char s : seed.toCharArray()) {
			if (s == 'X' || s == 'Y') {
				if (skip >= evolveCache[generations]) {
					skip -= evolveCache[generations];
				} else {
					return dragon(s == 'X' ? "X+YF" : "FX-Y", generations - 1, skip);
				}
			} else if (skip > 0) {
				skip--;
			} else {
				return s;
			}
		}

		return '0';
	}

	/**
	 * @param age
	 * @param p index of string, starting from 0.
	 * @param i
	 * @return
	 */
	public static String dragon0(int age, int p, int i) {
		if (age == 0) return "FX".substring(p, p + i);

		// Find the smallest position of previous age's dragon0.
		// l(a+1) = 2l(a) + 1, l(a) = (l(a+1) - 1)/2
		// makes wrong p0 and i0.
		int p0 = (int) Math.floor((p - 1) / 2.0);
		int i0 = (int) Math.floor((i - 1) / 2.0);
		String parents = dragon0(age - 1, p0, i0);

		String fromCache = mergeCache(parents);
		return fromCache.substring(0, i);
	}

	public static String mergeCache(String str) {
		if ("".equals(str)) return "";
		else if (cache0.containsKey(str)) return cache0.get(str);

		if (str.startsWith("+") || str.startsWith("-")) {
			return str.charAt(0) + mergeCache(str.substring(1));
		} else if (str.endsWith("+") || str.endsWith("-")) {
			int len = str.length();
			return mergeCache(str.substring(0, len)) + str.charAt(len - 1);
		}

		String val;
		if (str.length() <= 2) {
			// The first `replace` adds one `Y`, and affects the second `replace`.
			// Replacement should be done by manual copy.
			// val = str.replace("X", "X+YF").replace("Y", "FX-Y");

			StringBuffer sb = new StringBuffer();
			for (char ch : str.toCharArray()) {
				if (ch != 'X' && ch != 'Y') sb.append(ch);
				else if (ch == 'X') sb.append("X+YF");
				else sb.append("FX-Y");
			}
			val = sb.toString();
		} else {
			int mid = str.length() / 2;
			val = mergeCache(str.substring(0, mid))
				+ str.charAt(mid)
				+ mergeCache(str.substring(mid + 1));
		}
		cache0.put(str, val);
		return val;
	}

}
