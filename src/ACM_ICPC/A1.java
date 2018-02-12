package ACM_ICPC;

import java.util.*;
import java.lang.*;
import java.io.*;

class A1 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final long MOD = (long) 1e9 + 7;

    static int check(int a[], int b[]) {
        int flag = -1;
        if (a[1] >= b[1] && a[2] >= b[2] && a[3] >= b[3]) {
            if (a[1] > b[1] || a[2] > b[2] || a[3] > b[3]) {
                flag = 1;
            }
        }
        if (a[1] <= b[1] && a[2] <= b[2] && a[3] <= b[3]) {
            if (a[1] < b[1] || a[2] < b[2] || a[3] < b[3]) {
                flag = 2;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            boolean flag = false;
            int x[] = new int[4];
            int y[] = new int[4];
            int z[] = new int[4];

            for (int i = 1; i < 4; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 1; i < 4; i++) {
                y[i] = in.nextInt();
            }
            for (int i = 1; i < 4; i++) {
                z[i] = in.nextInt();
            }

            int ans = check(x, y);
            if (ans == 1) {
                if (check(y, z) == 1) {
                    flag = true;
                } else if (check(y, z) == 2 && check(x, z) > 0) {
                    flag = true;
                }
            } else if (ans == 2) {
                if (check(x, z) == 1) {
                    flag = true;
                } else if (check(x, z) == 2 && check(y, z) > 0) {
                    flag = true;
                }
            }

            if (flag == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}