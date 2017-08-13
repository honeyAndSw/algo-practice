package algostrategies.bruteforce06;

import java.util.*;

/**
 * Created by honey.and.sw on 2017. 8. 13.
 */
public class Picnic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseC = sc.nextInt();
        while (caseC-- > 0) {
            int studentN = sc.nextInt();
            Set<Integer> students = new LinkedHashSet<>();
            for (int i = 0; i < studentN; i++) students.add(i);

            int tupleM = sc.nextInt();
            boolean[][] friends = new boolean[studentN][studentN];
            for (int i = 0; i < tupleM; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                friends[a][b] = true;
                friends[b][a] = true;
            }

            System.out.println(countFriends(friends, students));
        }
    }

    public static int countFriends(boolean[][] friends, Set<Integer> students) {
        if (students.size() == 0) return 1;

        int count = 0;
        Integer[] studentArr = students.toArray(new Integer[0]);
        int wantMatch = studentArr[0];

        students.remove(wantMatch);

        for (int i = 0; i < studentArr.length; i++) {
            int next = studentArr[i];
            if (!friends[wantMatch][next]) continue;

            students.remove(next);
            count += countFriends(friends, students);
            students.add(next);
        }

        students.add(wantMatch);
        return count;
    }
}
