package HighFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: Group Shifted Strings
 */
public class GroupStrings {
    public static void main(String[] args) {}

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String shifted = shift(s);
            map.computeIfAbsent(shifted, x -> new ArrayList<>());
            map.get(shifted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String shift(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == 'a') {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(i) - (s.charAt(0)-'a'));
            if (c < 'a') {
                c = (char) (c + 26);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}