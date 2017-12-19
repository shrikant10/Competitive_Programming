package Algorithms;

public class GCD_Euclidean_algorithm {

    static int gcd(int l, int h) {
        if (l == 0) {
            return h;
        }
        return gcd(h % l, l);
    }

    public static void main(String[] args) {
        System.out.println("GCD: " + gcd(35, 10));
    }
}
