package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 282. Expression Add Operators
 */
public class AddOperators {
    public static void main(String[] args) {}

    List<String> res;
    int target;
    String num;
    // Time O(N*4^N)
    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        this.target = target;
        this.num = num;
        tryAdd("", 0, 0, 0);
        return this.res;
    }
    private void tryAdd(String path, int pos, long curr, long prev) {
        if (pos == this.num.length()) {
            if (curr == this.target) {
                this.res.add(path);
            }
            return ;
        }
        for (int i = pos+1; i <= this.num.length(); i++) {
            if (this.num.charAt(pos) == '0' && i != pos+1) {
                break;
            }
            long n = Long.parseLong(this.num.substring(pos, i));
            if (pos == 0) {
                tryAdd(path+n, i, n, n);
            } else {
                tryAdd(path+"+"+n, i, curr+n, n);
                tryAdd(path+"-"+n, i, curr-n, -n);
                tryAdd(path+"*"+n, i, curr-prev+prev*n, prev*n);
            }
        }
    }
}