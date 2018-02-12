package FEB_18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Chef_And_Land_Labeling {

    static int gcd(int l, int h) {
        if (l == 0) {
            return h;
        }
        return gcd(h % l, l);
    }

    static boolean compareArrays(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int count[] = new int[1001];
        int max_n = 0;
        while (t-- > 0) {
            int n = in.nextInt();
            if (n > max_n) {
                for (int i = max_n + 1; i <= n; i++) {
                    for (int j = 1; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            if (i / j == j) count[i]++;
                            else count[i] += 2;
                        }
                    }
                }
                max_n = n;
            }

            int cd[][] = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    cd[i][j] = count[gcd(i, j)];
                    cd[j][i] = cd[i][j];
                }
            }

            int m[][] = new int[n + 1][n + 1];
            long sum[] = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    m[i][j] = in.nextInt();
                    sum[i] += m[i][j];
                }
            }

            long sum_2[] = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sum_2[i] += cd[i][j];
                }
            }

            HashSet<Integer> p[] = new HashSet[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = new HashSet<Integer>();
            }

            boolean found[] = new boolean[n + 1];

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    if (sum[k] == sum_2[i]) {
                        p[k].add(i);
                    }
                }
            }

            for (int k = 1; k <= n; k++) {
                Iterator<Integer> i = p[k].iterator();
                while (i.hasNext()) {
                    int j = (int)i.next();
                    i.remove();
                    if (!found[j] && (p[k].isEmpty() || compareArrays(cd[j],m[k]))) {
                            System.out.println(j);
                            found[j]=true;
                            break;
                    }
                }
            }
        }
    }
}