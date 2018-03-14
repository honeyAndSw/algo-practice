package leetcode;

import java.util.Arrays;

public class ValidSquare593 {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		return validSquare(new double[]{distance(p2, p1), distance(p3, p1), distance(p4, p1)}) // p1
			&& validSquare(new double[]{distance(p1, p2), distance(p3, p2), distance(p4, p2)}) // p2
			&& validSquare(new double[]{distance(p1, p3), distance(p2, p3), distance(p4, p3)}); // p3
	}

	private boolean validSquare(double[] distances) {
		Arrays.sort(distances);
		return (distances[2] > 0) // positive length
			&& (distances[2] == distances[0] + distances[1]) // rectangle
			&& (distances[0] == distances[1]); // square
	}

	private double distance(int[] p1, int[] p2) {
		return Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2);
	}
}
