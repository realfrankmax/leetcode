package String;

/**
 * @leetcode: 408. Valid Word Abbreviation
 */
public class ValidWordAbbreviation {
    public static void main(String[] args) {}

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()){
            char w = word.charAt(i);
            char a = abbr.charAt(j);
            if (w == a) {
                i++;
                j++;
            } else {
                // Count shouldn't start with 0
                if (a > '0' && a <= '9'){
                    int count = 0;
                    // while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    //     count = 10*count + abbr.charAt(j)-'0';
                    //     j++;
                    // }
                    while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                        count = 10*count + Character.getNumericValue(abbr.charAt(j));
                        j++;
                    }
                    i += count;
                } else {
                    return false;
                }
            }
        }
        return i == word.length() && j == abbr.length();
    }
}