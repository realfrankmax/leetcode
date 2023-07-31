package Binary;

/**
 * @leetcode: 67. Add Binary
 */
public class AddBinary {
    public static void main(String[] args) {}

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int posA = a.length()-1;
        int posB = b.length()-1;
        while (posA >= 0 || posB >= 0 || carry != 0) {
            int numA = posA >= 0 ? a.charAt(posA) - '0' : 0;
            int numB = posB >= 0 ? b.charAt(posB) - '0' : 0;
            int sum = numA + numB + carry;
            sb.append(sum%2);
            carry = sum/2;
            posA--;
            posB--;
        }
        return sb.reverse().toString();
    }
}