package Math;

import java.util.Map;

/**
 * @leetcode: 13. Roman to Integer
 */
public class RomanToInt {
    public static void main(String[] args) {}

    public static final Map<Character, Integer> ROMAN_DICT = 
        Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
    
    public int romanToInt(String s) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            val += RomanToInt.ROMAN_DICT.get(s.charAt(i));
            if (i > 0 && RomanToInt.ROMAN_DICT.get(s.charAt(i)) > RomanToInt.ROMAN_DICT.get(s.charAt(i-1))) {
                val -= 2*RomanToInt.ROMAN_DICT.get(s.charAt(i-1));
            }
        }
        return val;
    }
}
