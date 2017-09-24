package algostrategies.dp08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numb3rs {

    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    private static double[][] cache;
    private static int[] degree;
    private static int prison;
    private static int townSize;
    private static int[][] town;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(stdin.readLine());
        while (cases-- > 0) {
            String[] targets = stdin.readLine().split(" ");
            int day = Integer.parseInt(targets[1]);

            townSize = Integer.parseInt(targets[0]);
            prison = Integer.parseInt(targets[2]);
            degree = new int[townSize];

            cache = new double[townSize + 1][day + 1];
            for (int t = 0; t < townSize + 1; t++) {
                for (int d = 0; d < day + 1; d++) {
                    cache[t][d] = -1.0;
                }
            }

            town = new int[townSize][townSize];
            for (int y = 0; y < townSize; y++) {
                String[] cells = stdin.readLine().split(" ");
                int deg = 0;

                for (int x = 0; x < townSize; x++) {
                    town[y][x] = Integer.parseInt(cells[x]);
                    deg += town[y][x];
                }

                degree[y] = deg;
            }

            int problem = Integer.parseInt(stdin.readLine());
            String[] problems = stdin.readLine().split(" ");
            StringBuffer result = new StringBuffer();

            for (int p = 0; p < problem; p++) {
                double r = solve(Integer.parseInt(problems[p]), day);
                result
                    .append(String.format(r + "", "%.8f"))
                    .append(" ");
            }

            System.out.print(result);
        }
    }

    /**
     * Java Implementation of Numb3rs.scala
     */
    private static double solve(int here, int day) {
        if (day == 0) {
            return here == prison ? 1.0 : 0.0;
        } else if (cache[here][day] > -0.5) {
            return cache[here][day];
        }

        double result = 0;

        for (int there = 0; there < townSize; there++) {
            if (town[there][here] == 1) {
                result += solve(there, day - 1) / degree[there];
            }
        }

        cache[here][day] = result;
        return result;
    }
}