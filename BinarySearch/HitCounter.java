package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 362. Design Hit Counter
 */
public class HitCounter {
    public static void main(String[] args) {}

    List<int[]> counters;
    public HitCounter() {
        this.counters = new ArrayList<>();
    }
    
    /**
     * Assume the input is monotonically increasing
     * Otherwise, we need to do a sort/merge or map reduce
     * @param timestamp
     */
    public void hit(int timestamp) {
        if (this.counters.size() == 0 || this.counters.get(this.counters.size()-1)[0] != timestamp) {
            this.counters.add(new int[]{timestamp, 0});
        }
        this.counters.get(this.counters.size()-1)[1]++;
    }
    
    public int getHits(int timestamp) {
        int left = 0;
        int right = this.counters.size()-1;
        int startPos = -1;
        // Find first pos whose timestamp is smaller than input
        while (left <= right) {
            int mid = (left+right)/2;
            if (this.counters.get(mid)[0] == timestamp) {
                startPos = mid;
                break;
            } else if (this.counters.get(mid)[0] > timestamp) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (startPos == -1) {
            if (right == -1) {
                return 0;
            }
            startPos = right;
        }
        int count = 0;
        while (startPos >= 0 && (timestamp-this.counters.get(startPos)[0]) < 300) {
            count += this.counters.get(startPos)[1];
            startPos--;
        }
        return count;
    }   
}
