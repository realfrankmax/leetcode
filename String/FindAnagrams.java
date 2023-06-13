package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: Find All Anagrams in a String
 */
public class FindAnagrams {
    public static void main(String[] args) {}

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : p.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (dict.containsKey(curr)) {
                if (dict.get(curr) > 0) {
                    count++;
                }
                dict.put(curr, dict.get(curr)-1);
                if (count == p.length()) {
                    res.add(start);
                }
            }
            // Once the substring len equals to p, always move start pointer on each loop.
            if (i - start+1 == p.length()) {
                char cstart = s.charAt(start);
                if (dict.containsKey(cstart)) {
                    if (dict.get(cstart) >= 0) {
                        count--;
                    }
                    dict.put(cstart, dict.get(cstart)+1);
                }
                start++;
            }
        }
        return res;
    }
}