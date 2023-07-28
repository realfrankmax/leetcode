package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @leetcode: 380. Insert Delete GetRandom O(1)
 */
public class RandomizedSet {
    public static void main(String[] args) {}

    private Map<Integer, Integer> pos;
    private List<Integer> nums;

    public RandomizedSet() {
        this.pos = new HashMap<>();
        this.nums = new ArrayList<>();   
    }
    
    public boolean insert(int val) {
        if (this.pos.containsKey(val)) {
            return false;
        }
        this.pos.put(val, this.nums.size());
        this.nums.add(val);
        return true;
    }
    
    // 1. Assign lastVal to val's position
    // 2. Remove lastVal
    public boolean remove(int val) {
        if (!this.pos.containsKey(val)) {
            return false;
        }
        int lastPos = this.nums.size()-1;
        int lastVal = this.nums.get(lastPos);
        if (val != lastVal) {
            int pos = this.pos.get(val);
            this.nums.set(pos, lastVal);
            this.pos.put(lastVal, pos);
        }
        this.nums.remove(lastPos);
        this.pos.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return this.nums.get(rand.nextInt(this.nums.size()));
    }
}