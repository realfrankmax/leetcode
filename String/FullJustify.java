package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 68. Text Justification
 */
public class FullJustify {
    public static void main(String[] args) {}

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() > maxWidth) {
                res.add(buildLine(words, start, i-1, maxWidth));
                len = 0;
                start = i;
                i--;
            } else if (len + words[i].length() == maxWidth) {
                res.add(buildLine(words, start, i, maxWidth));
                len = 0;
                start = i+1;
            } else {
                len += words[i].length()+1;
                if (i == words.length-1) {
                    res.add(buildLine(words, start, i, maxWidth));
                }
            }
        }
        return res;
    }
    private String buildLine(String[] words, int start, int end, int maxWidth) {
        int wordsLen = 0;
        for (int i = start; i <= end; i++) {
            wordsLen += words[i].length();
        }
        int diff = maxWidth-wordsLen;
        int spaceEach = 1;
        int spaceExtra = 0;
        if (start != end && end != words.length-1) {
            spaceEach = diff / (end-start);
            spaceExtra = diff % (end-start);
        }
        StringBuilder builder = new StringBuilder(words[start]);
        for (int i = start+1; i <= end; i++) {
            for (int j = 0; j < spaceEach; j++) {
                builder.append(" ");
            }
            if (spaceExtra-- > 0) {
                builder.append(" ");
            }
            builder.append(words[i]);
        }
        while (builder.length() < maxWidth) {
            builder.append(" ");
        }
        return builder.toString();
    }
}