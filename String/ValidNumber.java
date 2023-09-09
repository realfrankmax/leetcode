package String;

/**
 * @leetcode: 65. Valid Number
 */
public class ValidNumber {
    public static void main(String[] args) {}

    // Sieve method
    // If c is a sign, it has to be position 0 or following an "e"
    // If c is dot, there couldn't be dot or "e" before
    // If c is "e", there must be number before, must not be "e" before. 
    //     And must have number after
    public boolean isNumber(String s) {
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasNumber = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (!(i == 0 || s.charAt(i-1) == 'E' || s.charAt(i-1) == 'e')) {
                    return false;
                }
            } else if (c == '.') {
                if (hasE || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'E' || c == 'e') {
                if (hasE || !hasNumber) {
                    return false;
                }
                hasE = true;
                hasNumber = false;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else {
                return false;
            }
        }
        return hasNumber;
    }
}