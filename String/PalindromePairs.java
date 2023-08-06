package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 336. Palindrome Pairs
 */
public class PalindromePairs {
    public static void main(String[] args) {}

    // The combinations are a+b or b+a
    // If the combination is palindrome, the part of first str should be palindrome,
    // the second str is the reverse of the non-palindrome part of the first one.
    // The palinedrome part could be first half, which means the second str will prepend
    // The palinedrome part could be second half, which means the second str will append.
    // The only exception is that if first half is "", and second half is abcd,
    // We will look for dcba as second str.
    // Same for when the dcba as first str.
    // So only check one situtaion in such case when empty str is used in sub palinedrome.
    // s + lls

    // Time O(N*len^2)
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            idx.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int j = 0; j <= curr.length(); j++) {
                String sub1 = curr.substring(0, j);
                String sub2 = curr.substring(j);
                if (isPalindrome(sub1)) {
                    String revsub2 = new StringBuilder(sub2).reverse().toString();
                    if (idx.containsKey(revsub2) && idx.get(revsub2) != i) {
                        res.add(List.of(idx.get(revsub2), i));
                    }
                }
                if (sub2.length() != 0 && isPalindrome(sub2)) {
                    String revsub1 = new StringBuilder(sub1).reverse().toString();
                    if (idx.containsKey(revsub1) && idx.get(revsub1) != i) {
                        res.add(List.of(i, idx.get(revsub1)));
                    }
                }
            }
        }
        return res;
    }
    // O(N^2*len)
    // public List<List<Integer>> palindromePairs(String[] words) {
    //     List<List<Integer>> res = new ArrayList<>();
    //         for (int i = 0; i < words.length; i++) {
    //             for (int j = i+1; j < words.length; j++) {
    //                 if (isPalindrome(words[i]+words[j])) {
    //                     res.add(List.of(i, j));
    //                 }
    //                 if (isPalindrome(words[j]+words[i])) {
    //                     res.add(List.of(j, i));
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}