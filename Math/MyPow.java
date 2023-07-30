package Math;

/**
 * @leetcode: 50. Pow(x, n)
 */
public class MyPow {
    public static void main(String[] args) {}

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = 1.0;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                res *= 1/x;
                n++;
            }
            n = -n;
            x = 1/x;
        }
        
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x = x*x;
            n /= 2;   
        }
        return res;
    }
    /** 
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return 1/x * myPow(1/x, -(n+1));
        } else if (n < 0) {
            return myPow(1/x, -n);
        }
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
    */
}
