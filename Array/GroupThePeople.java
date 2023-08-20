package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 1282. Group the People Given the Group Size They Belong To
 */
public class GroupThePeople {
    public static void main(String[] args) {}

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> groups = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!groups.containsKey(size)) {
                groups.put(size, new ArrayList<>());
            }
            groups.get(size).add(i);
            if (groups.get(size).size() == size) {
                res.add(groups.get(size));
                groups.remove(size);
            }
        }
        return res;
    }
}
