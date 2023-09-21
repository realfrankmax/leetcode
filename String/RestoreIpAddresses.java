package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 93. Restore IP Addresses
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {}

    List<String> res;
    // Time O(M^(N-1)); M is 3 because max is 3 digits and N is because 4 parts
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper (String s, int start, List<String> address) {
        if (start == s.length() || address.size() == 4) {
            if (address.size() == 4 && start == s.length()) {
                res.add(parse(address));
            }
            return ;
        }
        for (int i = start+1; i <= s.length(); i++) {
            String curr = s.substring(start, i);
            if ((curr.length() > 1 && curr.charAt(0) == '0') || (Integer.parseInt(curr) > 255)) {
                break;
            }
            address.add(curr);
            helper(s, i, address);
            address.remove(address.size()-1);
        }
    }
    private String parse(List<String> address) {
        return String.join(".", address);
    }
}