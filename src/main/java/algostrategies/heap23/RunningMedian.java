package algostrategies.heap23;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			int len = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			long A = 0;
			long accum = 0;
			PriorityQueue<Long> max = createMaxHeap();
			PriorityQueue<Long> min = createMinHeap();

			for (int i = 0; i < len; i++) {
				A = (i == 0) ? 1983 : (A * a + b) % 20090711;
				accum = (accum + nextMedian(max, min, A)) % 20090711;
			}

			System.out.println(accum);
		}
	}

	public static PriorityQueue<Long> createMaxHeap() {
		return new PriorityQueue<>(Comparator.reverseOrder());
	}

	public static PriorityQueue<Long> createMinHeap() {
		return new PriorityQueue<>(/* natural order */);
	}

	public static long nextMedian(PriorityQueue<Long> max, PriorityQueue<Long> min, long next) {
		if (max.isEmpty()) {
			max.add(next);
			return next;
		}

		if (max.peek() < next) {
			min.add(next);
		} else {
			max.add(next);
		}

		while (max.size() > min.size() + 1) min.add(max.poll());
		while (min.size() > max.size()) max.add(min.poll());

		return max.peek() % 20090711;
	}
}
