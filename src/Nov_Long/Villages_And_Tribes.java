package Nov_Long;

import java.util.*;
import java.lang.*;
import java.io.*;

class Villages_And_Tribes {
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
            String s = in.next();
            char a[] = s.toCharArray();
            int n_A = 0;
            int n_B = 0;
            int n_dot = 0;
            int i = 0;
            char last;
            while (i < s.length() && a[i] == '.') {
                i++;
            }
            if (i == s.length()) {
                System.out.println(n_A + " " + n_B);
                continue;
            }
            last = a[i];
            while (i < s.length()) {
                if (a[i] == 'A') {
                    n_A++;
                    if (last == 'A') {
                        n_A += n_dot;
                    }
                    last = 'A';
                    n_dot = 0;
                } else if (a[i] == 'B') {
                    n_B++;
                    if (last == 'B') {
                        n_B += n_dot;
                    }
                    last = 'B';
                    n_dot = 0;
                } else {
                    n_dot++;
                }
                i++;
            }
            System.out.println(n_A + " " + n_B);
        }
    }
}