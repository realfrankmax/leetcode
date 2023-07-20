package HighFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: Dot Product of Two Sparse Vectors
 */
public class DotProduct {
    public static void main(String[] args) {}

    class SparseVector {
        // Build hashmap on non-zero items.

        // private Map<Integer, Integer> map;
        // SparseVector(int[] nums) {
        //     map = new HashMap<>();
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] != 0) {
        //             map.put(i, nums[i]);
        //         }
        //     }
        // }
        
        // // Return the dotProduct of two sparse vectors
        // public int dotProduct(SparseVector vec) {
        //     int result = 0;
        //     for (int key : this.map.keySet()) {
        //         if (vec.map.containsKey(key)) {
        //             result += this.map.get(key) * vec.map.get(key);
        //         }
        //     }
        //     return result;
        // }

        // Instead of hashing the indices, keep all non-zero items in a list
        List<int[]> list;
        SparseVector(int[] nums) {
            this.list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    this.list.add(new int[]{i, nums[i]});
                }
            }
        }
        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int result = 0;
            // int i = 0;
            // int j = 0;
            
            // while (i < this.list.size() && j < vec.list.size()) {
            //     if (this.list.get(i)[0] == vec.list.get(j)[0]) {
            //         result += this.list.get(i)[1] * vec.list.get(j)[1];
            //         i++;
            //         j++;
            //     } else if (this.list.get(i)[0] > vec.list.get(j)[0]) {
            //         j++;
            //     } else {
            //         i++;
            //     }
            // }

            // If one list is way larger than the other, use binary search solution
            if (this.list.size() > vec.list.size()) {
                for (int[] item : vec.list) {
                    result += item[1] * binarySearch(this.list, item[0]);
                }
            } else {
                for (int[] item : this.list) {
                    result += item[1] * binarySearch(vec.list, item[0]);
                }
            }
            return result;
        }
        
        private int binarySearch(List<int[]> list, int target) {
            int left = 0;
            int right = list.size()-1;
            while (left <= right) {
                int mid = (left + right)/2;
                if (list.get(mid)[0] == target) {
                    return list.get(mid)[1];
                } else if (list.get(mid)[0] > target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            return 0;
        }
    }
}
