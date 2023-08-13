package String;

/**
 * @leetcode: 680. Valid Palindrome II
 */
public class ValidPalindrome {
    public static void main(String[] args) {}

    // Greedy. 
    // Once we find unmatched character, check substrings with removed either left or right character.
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return isValid(s.substring(left, right)) || isValid(s.substring(left+1, right+1));
            }
        }
        return true;
    }
    private boolean isValid(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
