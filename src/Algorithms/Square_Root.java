package Algorithms;

public class Square_Root {

    static int sqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int l = 0;      // lower
        int u = n;      // upper
        int ans = 0;
        while (l <= u) {
            int mid = (l + u) / 2;
            int sqr = mid * mid;
            if (sqr == n) {
                return mid;
            } else if (sqr < n) {
                l = mid + 1;
                ans = mid;  // Closest Ans
            } else {
                u = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println(sqrt(n));
    }
}
