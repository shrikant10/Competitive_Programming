package FEB_18;

import java.util.Scanner;

class Points_Inside_A_Polygon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int a = n / 10;
            int x[] = new int[n];
            int y[] = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }

            long ans[][] = new long[2][a];
            int k = 0;
            int m = 0;

            while (k < n - 2 && m < a) {
                for (int i = k + 2; i < n; i++) {
                    if (k == 0 && i == n - 1) {
                        continue;
                    }
                    long _x = x[i] + (long) x[k];
                    long _y = y[i] + (long) y[k];
                    if (_x % 2 == 0 && _y % 2 == 0) {
                        ans[0][m] = _x / 2;
                        ans[1][m] = _y / 2;
                        m++;
                        if (m == a) {
                            break;
                        }
                    }
                }
                k++;
            }

            if (m < a) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < a; i++) {
                    System.out.println(ans[0][i] + " " + ans[1][i]);
                }
            }
        }
    }
}