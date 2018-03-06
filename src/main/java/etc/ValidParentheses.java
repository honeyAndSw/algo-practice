package etc;

public class ValidParentheses {
    // (()(())) - true
    // ()) - false
    // ({()}(())) - true
    // ( ( { } ) ) - true
    // ( { ( } ) ) - false
    boolean isValidParen(String input) {
        int openCnt = 0;
        int openCurCnt = 0;
        for (char ch : input.toCharArray()) {
            // Update counts
            //if (isOpenParen(ch)) openCnt++;
            //else if (isCloseParen(ch)) openCnt--;
            if (ch == '(' || ch == ')') {
                openCnt = openCnt + (isOpenParen(ch) ? 1 : -1);
            } else if (ch == '{' || ch == '}') {
                openCurCnt = openCurCnt + (isOpenParen(ch) ? 1 : -1);
            }

            if (openCnt < 0 || openCurCnt < 0) {
                return false;
            }
        }

        return openCnt == 0 && openCurCnt == 0;
    }

    boolean isOpenParen(char ch) {
        return ch == '(' || ch == '{';
    }

    boolean isCloseParen(char ch) {
        return ch == ')' || ch == '}';
    }

    /********************************************
    play_events: [user_id, track_id, timestamp]

    groupby - O(N)
    orderby - O(TlogT), T = # of track_id
    O(N) + O(TlogT)

    select track_id, count(1) as numPlayed
    from play_events
    group by track_id
    order by numPlayed desc
    limit 5;

    playEvents
        .map(event => (event.trackId, 1))
        .reduce((kv1, kv2) => if kv1.trackId == kv2.trackId then accum)
        .sort()
        .take(limit)
    ********************************************/

    /********************************************
    user,
    playlistid,
    ... other columns...
    PK (user, playlistid)

    /playlist/{user}, POST
    /playlist/{user}/{playlistid} DELETE
    /playlist/{user}, GET
    /playlist/{user}/{playlistid}, GET
    ********************************************/
}
