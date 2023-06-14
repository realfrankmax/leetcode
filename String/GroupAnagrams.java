package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: Group Anagrams
 */
public class GroupAnagrams {
    public static void main(String[] args) {}

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = sort(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        char[] c = s.toCharArray();
        // Arrays.sort(c);
        mergeSort(c, 0, c.length-1);
        return new String(c);
    }

    private void mergeSort(char[] c, int start, int end) {
        // Termination condition
        if (start >= end) {
            return ;
        }
        int mid = start + (end-start)/2;
        mergeSort(c, start, mid);
        mergeSort(c, mid+1, end);
        merge(c, start, mid, end);
    }

    private void merge(char[] c, int start, int mid, int end) {
        // Note: Sort sub-array from start to end
        int len1 = mid-start+1;
        int len2 = end-mid;
        char[] sub1 = new char[len1];
        char[] sub2 = new char[len2];
        for (int i = start; i <= mid; i++) {
            sub1[i-start] = c[i];
        }
        for (int i = mid+1; i <= end; i++) {
            sub2[i-mid-1] = c[i];
        }
        int idx = start;
        int i1 = 0;
        int i2 = 0;
        // Merge into char[] c from start to end
        while (idx <= end) {
            if (i1 == len1) {
                c[idx] = sub2[i2];
                i2++;
            } else if (i2 == len2) {
                c[idx] = sub1[i1];
                i1++;
            } else if (sub1[i1] < sub2[i2]) {
                c[idx] = sub1[i1];
                i1++;
            } else {
                c[idx] = sub2[i2];
                i2++;
            }
            idx++;
        }
    }
}