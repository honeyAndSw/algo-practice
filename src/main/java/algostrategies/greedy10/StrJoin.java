package algostrategies.greedy10;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * StrJoin
 *
 * @author naheon
 * @since 2017. 11. 02.
 */
public class StrJoin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			int len = sc.nextInt();
			LinkedList<Integer> lens = new LinkedList<>();
			for (int i = 0; i < len; i++) {
				lens.add(sc.nextInt());
			}
			System.out.println(joinStr(lens));
		}
	}

	public static int joinStr(LinkedList<Integer> lens) {
		int accum = 0;

		while (!lens.isEmpty() && lens.size() > 1) {
			lens.sort(Comparator.naturalOrder());

			int sum = lens.pop() + lens.pop();
			lens.push(sum);

			accum += sum;
		}

		return accum;
	}
}
