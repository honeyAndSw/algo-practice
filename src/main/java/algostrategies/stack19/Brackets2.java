package algostrategies.stack19;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Brackets2
 *
 * @author naheon
 * @since 2017. 12. 08.
 */
public class Brackets2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			boolean isMatched = match(sc.next());
			System.out.println(isMatched ? "YES" : "NO");
		}
	}

	public static boolean match(String str) {
		if (str == null || str.length() == 0) return false;

		LinkedList<Character> stack = new LinkedList<>();
		char[] brackets = str.toCharArray();
		stack.push(brackets[0]);

		int i = 1;
		while (i < brackets.length) {
			char b = brackets[i];
			if (isOpen(b)) {
				stack.push(b);
			} else if (stack.isEmpty()) {
				return false;
			} else {
				char open = stack.pop();
				if (!isMatch(open, b)) return false;
			}

			i++;
		}

		return stack.isEmpty();
	}

	private static boolean isOpen(Character ch) {
		return ch == '(' || ch == '{' || ch == '[';
	}

	private static boolean isMatch(Character open, Character close) {
		switch(open) {
			case '(': return close == ')';
			case '{': return close == '}';
			case '[': return close == ']';
			default: return false;
		}
	}
}
