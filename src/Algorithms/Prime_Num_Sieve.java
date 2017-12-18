package Algorithms;

public class Prime_Num_Sieve {

    static void prime_num(int n) {

        boolean prime[] = new boolean[n + 1];     // Initially all variables are false
        int sqrt = (int) Math.sqrt(n);
        for (int p = 2; p <= sqrt; p++) {
            if (!prime[p]) {                      // false means prime
                for (int i = 2; i * p <= n; i++) {
                    prime[p * i] = true;            // Marking the non prime numbers
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!prime[i])
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int n = 50;
        prime_num(n);
    }
}
