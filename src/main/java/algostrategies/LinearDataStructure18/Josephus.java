package algostrategies.linearDataStructure18;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Josephus
 *
 * @author naheon
 * @since 2017. 12. 08.
 */
public class Josephus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			LinkedList<Integer> lastTwo = lastTwo(N, K);
			System.out.println(lastTwo.get(0) + " " + lastTwo.get(1));
		}
	}

	static LinkedList<Integer> lastTwo(int N, int K) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add((Integer) i);
		}

		return lastTwo(list, K);
	}

	static LinkedList<Integer> lastTwo(LinkedList<Integer> list, int K) {
		int index = 0;
		while (list.size() > 2) {
			/*
			 * Because `LinkedList#remove` iterates list to find element at index,
			 * time complexity could be inefficient.
			 * But LinkedList's `Node` is strictly private
			 * that it's impossible to remain `Node` as pointer outside of LinkedList.
			 *
			 * public E remove(int index) {
        	 * 	checkElementIndex(index);
        	 * 	return unlink(node(index));
    		 * }
			 */
			list.remove(index);
			index += K - 1;
			if (index >= list.size()) {
				index %= list.size();
			}
		}
		return list;
	}
}
