package String;

/**
 * @leetcode: 8. String to Integer (atoi)
 */
public class MyAtoi {
    public static void main(String[] args) {}

    /**
     * Read in and ignore any leading whitespace.
     * Check if the leading character is '-' or '+'.
     * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
     * If no digits were read, then the integer is 0
     */
    public int myAtoi(String s) {
        s = removePrefixSpaces(s);
        if (s.equals("")) {
            return 0;
        }
        int i = 0;
        boolean isPositive = true;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            i++;
            isPositive = false;
        }
        int res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int d = Character.getNumericValue(s.charAt(i));
            // res is always positive
            if (res > (Integer.MAX_VALUE-d)/10) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10*res + d;
            i++;
        }
        return isPositive ? res : -res;
    }
    
    private String removePrefixSpaces(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        return s.substring(i);
    }
}