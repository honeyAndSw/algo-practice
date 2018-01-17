package etc;

/*
You are building a chapter suggestion algorithm for a reader.
You know each chapter length in pages and are given a duration in days for the user to complete this book. 
Come up with an algorithm/function which can suggest a book reader, the chapters to be read by day to day basis.

Please note : 
1) The chapters suggested should be consecutive and in order. 
2) The reader cannot read partial chapters, once started he will complete the chapter on same day.

Input can be assumed in the form of zero indexed integer array
    - index represents chapter number, value is the number of pages in the chapter. 
Second parameter is the number of days in which the user wants to read the book.

Eg :
Arr = [ 10, 3, 8, 4, 12, 5, 9, 2, 4, 11, 7]  (total 75 pages)
Days = 5

Output : 
Day  :  Chapter numbers
 1      0, 1           i.e  13 pages
 2      2, 3           i.e. 12 pages
 3      4, 5           i.e. 17 pages
 4      6, 7, 8        i.e. 15 pages
 5      9, 10          i.e. 18 pages
*/

import java.util.ArrayList;
import java.util.List;

public class SuggestPages {
    public List<Integer> getPagesSuggestion(List<Integer> book, int days) {
        int N = book.size();

        int total = 0;
        for (int i = 0; i < N; i++) {
            total += book.get(i);
        }

        double d = days;
        double expected = total / d;

        List<Integer> dailyPages = new ArrayList<>(N);

        int sum = 0;
        int b = 0;
        while (b < N) {
            sum += book.get(b);

            if (sum >= expected) {
                double diff1 = sum - expected; // 21 - 15 = 6
                double diff0 = expected - sum + book.get(b);
                // 21(10, 3, 8) - 8 - 15 = -2
                if (diff0 < diff1) {
                    b--;
                    sum -= book.get(b-1);
                }

                dailyPages.add(sum);
                expected = (total - sum) / (--d);
                sum = 0;
            }

            b++;
        }

        return dailyPages;
    }
}
