package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

// Recursive   - Nothing is saved.
// Memoization - Top Down - Lookup Table - Sub problems are calculated when required
// Tabular     - Bottom Up - Sub Problems are solved first


public class Fibonacci {

    final int MAX = 100;
    final int NIL = -1;
    int lookup[] = new int[MAX];

    void _initialize() {
        Arrays.fill(lookup, NIL);
        lookup[0] = 0;
        lookup[1] = 1;
    }

    int fib(int n) {
        if (lookup[n] == NIL) {
            lookup[n] = fib(n - 1) + fib(n - 2);
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f._initialize();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(f.fib(n));
    }
}
