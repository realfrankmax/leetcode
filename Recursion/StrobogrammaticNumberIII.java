package Recursion;

import java.util.Map;

/**
 * @leetcode: 248. Strobogrammatic Number III
 */
public class StrobogrammaticNumberIII {
    public static void main(String[] args) {}

    static Map<Character, Character> PAIRS = Map.of('6', '9', '1', '1', '0', '0', '8', '8', '9', '6');
    int count;
    public int strobogrammaticInRange(String low, String high) {
        this.count = 0;
        for(int i = low.length(); i <= high.length(); i++){
            helper(low, high, new char[i], 0, i-1);
        }
        return this.count;
    }
    private void helper(String low, String high, char[] arr, int left, int right){
        if (left > right) {
            String curr = new String(arr);
            if ((curr.length() == low.length() && low.compareTo(curr) > 0)
                ||  (curr.length() == high.length() && high.compareTo(curr) < 0)){
                return ;
            }
            this.count++;
            return;
        }
        for(char c : PAIRS.keySet()){
            arr[left] = c;
            arr[right] = PAIRS.get(c);
            if (arr[0] == '0' && arr.length > 1){
                continue;
            }
            if (left == right && c != PAIRS.get(c)){
                continue;
            }
            helper(low, high, arr, left+1, right-1);
        }
    }
}