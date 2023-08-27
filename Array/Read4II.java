package Array;

/**
 * @leetcode: 158. Read N Characters Given read4 II - Call Multiple Times
 */
public class Read4II {
    public static void main(String[] args) {}

    char[] buf4 = new char[4];
    int pointer4 = 0;
    int readCount = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        int i = 0;
        while (i < n) {
            if (pointer4 == 0) {
                readCount = read4(buf4);
            }
            if (readCount == 0) {
                break;
            }
            while (pointer4 < readCount && i < n) {
                buf[i++] = buf4[pointer4++];
            }
            if (pointer4 == readCount) {
                pointer4 = 0;
                readCount = 0;
            }
        }
        return i;
    }
    int read4(char[] buf4) {
        return -1;
    } 
}
