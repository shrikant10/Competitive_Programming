package Algorithms;

public class GCD_Euclidean_algorithm {

    static int gcd(int l, int h) {
        if (l == 0) {
            return h;
        }
        return gcd(h % l, l);
    }

    static int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

    static int[] extended_gcd(int l, int h){
         int res[] = new int[3];
         if(l==0){
             res[0]=0;
             res[1]=1;
             res[2]=h;
             return res;
         }
         return extended_gcd(h%l, l);
    }
    public static void main(String[] args) {

        System.out.println("GCD: " + gcd(35, 10));
    }
}
