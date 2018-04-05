package hackerrank;

public class CamelCase {
    int camelcase(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') count++;
        }
        return count + 1;
    }
}
