package etc;
/*
1. Explain the CAP theorem and discuss its repercussions
    on current state of distributed systems.

2. Implement a circular buffer.
    A circular buffer is a data structure that uses a single, fixed-size buffer
    as if it were connected end-to-end.

    ['','','','','','','','']
    write('hi')
    ['h','i','','','','','','']
    write('you')
    read -> 'hi'
    ['h','i','y','o','u','','','']
    write('grab')
    ['b','i','y','o','u','g','r','a']
    read() -> 'you'
    read() -> 'grab'
 */

import java.util.List;

public class CircularBuffer {
    private char[] buffer;
    private int bufferIndex; // index to write
    private List<Integer> pointers;

    public String read() {
        if (pointers.isEmpty()) {
            return null;
        }

        if (pointers.size() > 1) {
            return toString(pointers.get(0), pointers.get(1));
        }
        return toString(pointers.get(0), bufferIndex);
    }

    private String toString(int start, int end) {
        // TODO
        return null;
    }

    // 'r', 'a', 'b', ......... 'g'
    // 'h', 'i', 'a', 'b', 'c', ''
    // w 'hi' p(0)
    // w 'abc' p(2)
    // w 'grab' 5 + 4 = 9 --- required = 3 --> 1 --> -2
    public void write(String s) {
        if (s == null || s.length() == 0 || s.length() > buffer.length) {
            // TODO logging errors...
            return;
        }

        if (bufferIndex + s.length() > buffer.length) {
            int required = bufferIndex + s.length() - buffer.length;
            while (!pointers.isEmpty() && required >= 0) {
                int firstPointer = pointers.remove(0);
                int prev =
                        (pointers.isEmpty() ? buffer.length : pointers.get(0))
                                - firstPointer;
                required -= prev;
            }
        }

        pointers.add(bufferIndex);
        for (int i = 0; i < s.length(); i++) {
            buffer[bufferIndex] = s.charAt(i);
            bufferIndex++;
            bufferIndex %= buffer.length;
        }
    }
}
