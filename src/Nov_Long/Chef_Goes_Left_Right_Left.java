package Nov_Long;

import java.util.*;
import java.lang.*;
import java.io.*;

class Chef_Goes_Left_Right_Left {
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


    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int r = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            boolean flag = true;
            int dir;    //0 - left  1 - right
            int min = -1;
            int max = Integer.MAX_VALUE;
            if (a[0] > r) {
                dir = 0;
                max = a[0];
            } else {
                dir = 1;
                min = a[0];
            }
            for (int i = 1; i < n - 1; i++) {
                if (dir == 0) {
                    if (a[i] > a[i - 1] || a[i] < min) {
                        flag = false;
                        break;
                    }
                } else {
                    if (a[i] < a[i - 1] || a[i] > max) {
                        flag = false;
                        break;
                    }
                }
                if (a[i] > r) {
                    dir = 0;
                    max = a[i];
                } else {
                    dir = 1;
                    min = a[i];
                }
            }

            if (flag == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}