package FEB_18;

import java.util.Scanner;

public class Car_pal_Tunnel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a[] = new int[n];
            long f = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                f += a[i];
            }
            long c = in.nextLong();
            int d = in.nextInt();
            int s = in.nextInt();
            long l = f + (long) a[0] * (c - 1);
            long last = a[0];
            for (int i = 1; i < n; i++) {
                if (a[i] > last) {
                    l += (a[i] - last) * (c - 1);
                    last = a[i];
                }
            }
            double ans = l - f;
            System.out.println(ans);
        }
    }
}