package algostrategies.tree21;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Fortress
 *
 * @author naheon
 * @since 2018. 01. 11.
 */
public class Fortress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int casesM = sc.nextInt();
		while (casesM-- > 0) {
			int numOfCircles = sc.nextInt();
			int[][] circles = new int[numOfCircles][3];

			for (int i = 0; i < numOfCircles; i++) {
				for (int j = 0; j < 3; j++) {
					circles[i][j] = sc.nextInt();
				}
			}

			Wall outermost = new Wall(new Circle(circles[0][0], circles[0][1], circles[0][2]));
			Arrays.stream(circles)
				.skip(1)
				.forEach(c -> outermost.append(new Circle(c[0], c[1], c[2])));

			System.out.println(countMaxWall(outermost));
		}
	}

	public static class Circle {
		int x;
		int y;
		int r;

		public Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		public boolean contains(Circle that) {
			double len = Math.sqrt(Math.pow(x - that.x, 2) + Math.pow(y - that.y, 2));
			return ((double) r) - len > 0;
		}
	}

	public static class Wall {
		int maxInnerWallCount = 0;
		List<Wall> walls = new LinkedList<>();
		Circle circle;

		public Wall(Circle circle) {
			this.circle = circle;
		}

		public void append(Circle circle) {
			for (Wall inner : this.walls) {
				if (inner.contains(circle)) {
					// If inner wall contains circle, try recursively.
					inner.append(circle);
					this.maxInnerWallCount = Math.max(this.maxInnerWallCount, inner.maxInnerWallCount + 1);
					return;
				}
			}

			// NO inner wall containing circle, append it to itself.
			this.walls.add(new Wall(circle));
			this.maxInnerWallCount = Math.max(this.maxInnerWallCount, 1);
		}

		private boolean contains(Circle circle) {
			return this.circle.contains(circle);
		}
	}

	public static int countMaxWall(Wall outermost) {
		List<Wall> walls = outermost.walls;
		int N = walls.size();

		if (N == 0) return N;
		else if (N == 1) return outermost.maxInnerWallCount;

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				max = Math.max(max,
						walls.get(i).maxInnerWallCount + walls.get(j).maxInnerWallCount + 2);
			}
		}

		return max;
	}
}
