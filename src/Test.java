import java.lang.*;
import java.util.*;
import java.io.*;

public class Test {

    static final long MOD = (long) 1e9 + 7;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        while (z-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int t[] = new int[m + 1];
            int l[] = new int[m + 1];
            int r[] = new int[m + 1];

            for (int i = 1; i <= m; i++) {
                t[i] = in.nextInt();
                l[i] = in.nextInt();
                r[i] = in.nextInt();
            }

            long times[] = new long[m + 1];
            Arrays.fill(times, 1);
            for (int i = m; i > 0; i--) {
                if (t[i] == 2) {
                    for (int j = l[i]; j <= r[i]; j++) {
                        times[j] += times[i];
                    }
                }
            }

            long a[] = new long[n + 2];
            long da[] = new long[n + 1];

            for (int i = 1; i <= m; i++) {
                if (t[i] == 1) {
                    da[r[i]] += times[i];
                    da[l[i] - 1] -= times[i];
                }
            }

            for (int i = n; i >= 1; i--) {
                a[i] = (a[i + 1]%MOD + da[i]%MOD)%MOD;
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
