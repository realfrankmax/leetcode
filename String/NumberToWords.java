package String;

/**
 * @leetcode: 273. Integer to English Words
 */
public class NumberToWords {
    public static void main(String[] args) {}

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", 
        "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", 
        "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String word = "";
        int i = 0;
        while (num != 0) {
            if (num%1000 != 0) {
                word = read(num%1000) + THOUSANDS[i] + " " + word;
            }
            i++;
            num /= 1000;
        }
        return word.trim();
    }
    
    private String read(int num) {
        if (num == 0) {
            return "";
        }
        if (num >= 100) {
            return LESS_THAN_20[num/100] + " Hundred " + read(num%100);
        } else if (num >= 20) {
            return TENS[num/10] + " " + read(num%10);
        } else {
            return LESS_THAN_20[num] + " ";
        }
    }
}
