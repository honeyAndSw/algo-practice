package leetcode;

/**
 * SwapAdjacentLrString
 *
 * @author naheon
 * @since 2018. 04. 02.
 */
public class SwapAdjacentLrString {
	public boolean canTransform(String start, String end) {
		return (start.length() == end.length())
			&& (sort(start).equals(sort(end)));
	}

	public String sort(String input) {
		char[] str = input.toCharArray();
		int len = input.length(),
			s = 0, e = s + 1;

		while (e < len) {
			switch (str[s]) {
				case 'L':
					switch (str[e]) {
						case 'L':
							swap(str, s+1, e);
							break;
						case 'R':
							s = e + 1;
							e = s + 1;
							break;
						case 'X':
							e++;
							break;
					}
					break;
				case 'R':
					switch (str[e]) {
						case 'L':
						case 'R':
							swap(str, s, e-1);
							s = e + 1;
							e = s + 1;
							break;
						case 'X':
							if (e == len - 1) {
								swap(str, s, e);
							}
							e++;
							break;
					}
					break;
				case 'X':
					switch (str[e]) {
						case 'L':
							swap(str, s, e);
						case 'R':
							s = e + 1;
							e = s + 1;
							break;
						case 'X':
							e++;
							break;
					}
					break;
			}
		}

		System.out.println(str);
		return new String(str);
	}

	String sort1(String input) {
		char[] str = input.toCharArray();
		int s = 0, e = s + 1;

		while (e < input.length()) {
			if (str[e] == 'X') {
				e++;
				continue;
			}

			if (str[e] == 'L') {
				if (str[s] == 'R') {
					swap(str, s, e-1);
				} else if (str[s] == 'L') {
					swap(str, s+1, e);
				} else { // str[s] == 'X'
					swap(str, s, e);
				}
			} else { // e == 'R'
				if (str[s] == 'R') {
					swap(str, s, e-1);
				} else if (str[s] == 'X') {
					swap(str, s, e);
				}
			}

			s = e+1;
			e = s+1;
		}

		// TODO e == str.length() - 1
		String ret = new String(str);
		System.out.println(ret);
		return ret;
	}

	void swap(char[] str, int idx1, int idx2) {
		char temp = str[idx1];
		str[idx1] = str[idx2];
		str[idx2] = temp;
	}
}
