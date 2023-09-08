package String;

/**
 * @leetcode: 38. Count and Say
 */
public class CountAndSay {
    public static void main(String[] args) {}

    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        while (n > 1) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            char c = curr.charAt(0);
            for (int i = 1; i < curr.length(); i++) {
                if (curr.charAt(i) != c) {
                    next.append(count);
                    next.append(c);
                    count = 1;
                    c = curr.charAt(i);
                } else {
                    count++;
                }
            }
            next.append(count).append(c);
            curr = next;
            n--;
        }
        return curr.toString();
    }
}
