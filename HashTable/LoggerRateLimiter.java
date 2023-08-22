package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 359. Logger Rate Limiter
 */
public class LoggerRateLimiter {
    public static void main(String[] args) {}

    Map<String, Integer> log;
    public LoggerRateLimiter() {
        log = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.log.containsKey(message)) {
            if (this.log.get(message) + 10 > timestamp) {
                return false;
            }
        }
        this.log.put(message, timestamp);
        return true;
    }
}
