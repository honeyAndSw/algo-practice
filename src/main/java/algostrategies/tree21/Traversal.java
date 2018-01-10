package algostrategies.tree21;

import java.util.Scanner;

public class Traversal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int casesM = sc.nextInt();
		while (casesM-- > 0) {
			int N = sc.nextInt();

			int[] pre = new int[N], in = new int[N];
			for (int i = 0; i < N; i++) pre[i] = sc.nextInt();
			for (int i = 0; i < N; i++) in[i] = sc.nextInt();

			initialize(pre, in);
			System.out.println(toPostOrder());
		}
	}

	static int[] PRE;
	static int[] IN;

	static void initialize(int[] pre, int[] in) {
		PRE = pre;
		IN = in;
	}

	static String toPostOrder() {
		int N = PRE.length;
		return toPostOrder(0, N, 0, N);
	}

	/**
	 * @param p0 inclusive start index of `PRE`
	 * @param p1 exclusive end index of `PRE`
	 * @param i0 inclusive start index of `IN`
	 * @param i1 exclusive end index of `IN`
	 * @return
	 */
	static String toPostOrder(int p0, int p1, int i0, int i1) {
		if (p1 - p0 == 0) return "";
		else if (p1 - p0 == 1) return Integer.toString(PRE[p0]);

		int root = PRE[p0];
		int inRootIdx = i0;
		while (IN[inRootIdx] != root) inRootIdx++;

		int leftSubSize = inRootIdx - i0;
		String left = toPostOrder(p0 + 1, p0 + leftSubSize + 1, i0, i0 + leftSubSize);
		String right = toPostOrder(p0 + leftSubSize + 1, p1, inRootIdx + 1, i1);

		return (!"".equals(left) ? left + " " : "")
			+ (!"".equals(right) ? right + " " : "")
			+ root;
	}
}
