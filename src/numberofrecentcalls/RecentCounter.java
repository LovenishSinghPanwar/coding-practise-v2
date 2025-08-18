package numberofrecentcalls;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {

    List<Integer> counter;
    Integer leftIndex;

    public RecentCounter() {
        this.counter = new ArrayList<>();
        this.leftIndex = 0;
    }

    public int ping(int t) {
        counter.add(t);
        while (!((counter.get(leftIndex) >= (t - 3000)) && (counter.get(leftIndex) < (t)))) {
            if(leftIndex == counter.size()-1) {
                break;
            }
            leftIndex++;
        }
        return counter.size() - leftIndex;
    }
}
