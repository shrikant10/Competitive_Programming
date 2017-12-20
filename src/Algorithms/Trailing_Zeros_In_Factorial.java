package Algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Trailing_Zeros_In_Factorial {

    public static int trailing_zeros(int n) {
        int count = 0;
        int d = 5;
        int div = n / d;
        while (div > 0) {
            count += div;
            d *= 5;
            div = n / d;
        }
        return count;
    }

    // Function to find numbers whose factorials have n trailing zeros.
    /*
    public static int[] numbers(int x) {
        int a[] = new int[5];

        int l = 0;      // lower
        int u = x*5;      // upper
        int ans = 0;
        while (l <= u) {
            int mid = (l + u) / 2;
            int zeros = trailing_zeros(mid);
            if (zeros == n) {
                ans = mid;
            } else if (zeros < n) {
                l = mid + 1;
                ans = mid;  // Closest Ans
            } else {
                u = mid - 1;
            }
        }

        return a;
    }
    */
    public static void main(String[] args) {
        int n = 129;
        System.out.println(trailing_zeros(n));
        int x = 5;
        //  System.out.println(Arrays.toString(numbers(x)));
    }
}
