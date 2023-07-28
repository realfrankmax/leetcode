package HighFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @leetcode: 381. Insert Delete GetRandom O(1) - Duplicates allowed
 */
public class RandomizedCollection {
    public static void main(String[] args) {}

    private Map<Integer, Set<Integer>> posMap;
    private List<Integer> numList;

    public RandomizedCollection() {
        this.posMap = new HashMap<>();
        this.numList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean doesExist = this.posMap.containsKey(val);
        this.posMap.computeIfAbsent(val, x -> new HashSet<>());
        this.posMap.get(val).add(this.numList.size());
        this.numList.add(val);
        return !doesExist;
    }
    
    public boolean remove(int val) {
        if (!this.posMap.containsKey(val)) {
            return false;
        }
        int lastPos = this.numList.size()-1;
        int lastVal = this.numList.get(lastPos);
        if (val != lastVal) {
            int pos = this.posMap.get(val).iterator().next();
            this.numList.set(pos, lastVal);
            this.posMap.get(val).remove(pos);
            this.posMap.get(lastVal).add(pos);
        }
        this.numList.remove(lastPos);
        this.posMap.get(lastVal).remove(lastPos);
        if (this.posMap.get(val).isEmpty()) {
            this.posMap.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        Random r = new Random();
        return this.numList.get(r.nextInt(this.numList.size()));
    }
}
