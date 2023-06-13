package String;

/**
 * @leetcode: String to Integer (atoi)
 */
public class MyAtoi {
    public static void main(String[] args) {}

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
        while (i < s.length() && isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            // res is always positive
            if (res > (Integer.MAX_VALUE-d)/10) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10*res + d;
            i++;
        }
        return isPositive ? res : -res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private String removePrefixSpaces(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        return s.substring(i);
    }
}