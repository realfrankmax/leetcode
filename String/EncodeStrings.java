package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 271. Encode and Decode Strings
 */
public class EncodeStrings {
    public static void main(String[] args) {}

    private char delimiter = '/';
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len).append(this.delimiter).append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == this.delimiter) {
                res.add(s.substring(i+1, i+1+len));
                i = i+len;
                len = 0;
            } else {
                len = len * 10 + Character.getNumericValue(s.charAt(i));
            }
        }
        return res;
        // List<String> list = new ArrayList<>();
        // int i = 0;
        // while(i < s.length()){
        //     int len = 0;
        //     while(s.charAt(i) != '/'){
        //         len = 10*len + s.charAt(i) - '0';
        //         i++;
        //     }
        //     list.add(s.substring(i+1, i+1+len));
        //     i = i+len+1;
        // }
        // return list;
    }
}
