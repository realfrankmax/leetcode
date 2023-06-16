package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: Time Based Key-Value Store
 */
public class TimeMap {
    public static void main(String[] args) {}

    Map<String, List<Integer>> timestamps;
    Map<String, String> values;
    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timestamps.containsKey(key)) {
            timestamps.put(key, new ArrayList<>());
        }
        timestamps.get(key).add(timestamp);
        values.put(key+timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // To search keys from some time, it requires binary search.
        if (!timestamps.containsKey(key)) {
            return "";
        }
        List<Integer> stamps = timestamps.get(key);
        int left = 0;
        int right = stamps.size()-1;
        int targetTime = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (stamps.get(mid) == timestamp) {
                targetTime = timestamp;
                break;
            } else if (stamps.get(mid) > timestamp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // !!!!!!
        if (right == -1) {
            return "";
        }
        if (targetTime == -1) {
            targetTime = stamps.get(right);
        }
        return values.get(key+targetTime);
    }
}