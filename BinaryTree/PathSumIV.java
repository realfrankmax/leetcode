package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 666. Path Sum IV
 */
public class PathSumIV {
    public static void main(String[] args) {
        PathSumIV s = new PathSumIV();
        int[] a = {113,215,221};
        s.pathSum(a);
        System.out.println(s.res);
        System.out.println(s.paths.toString());
    }

    int res;
    Map<Integer, Integer> nodes;
    List<String> paths;
    public int pathSum(int[] nums) {
        this.res = 0;
        this.nodes = new HashMap<>();
        paths = new ArrayList<>();
        for (int n : nums) {
            this.nodes.put(n/10, n%10);
        }
        sumToLeaf(nums[0]/10, 0, new ArrayList<>());
        return this.res;
    }

    public void sumToLeaf(int node, int sum, List<Integer> path) {
        if (!this.nodes.containsKey(node)) {
            return ;
        }
        sum += this.nodes.get(node);
        path.add(this.nodes.get(node));
        int depth = node/10;
        int pos = node%10;
        int leftChild = 10*(depth+1) + pos*2-1;
        int rightChild = 10*(depth+1) + pos*2;
        if (!this.nodes.containsKey(leftChild) && !this.nodes.containsKey(rightChild)) {
            this.res += sum;
            this.paths.add(path.toString());
        }
        sumToLeaf(leftChild, sum, path);
        sumToLeaf(rightChild, sum, path);
        path.remove(path.size()-1);
    }
}