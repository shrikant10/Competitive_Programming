package Nov_Long;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;

public class Polynomials {
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

    public static void main(String args[]) throws java.lang.Exception {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int eqn[][] = new int[n][4];
            int sum[] = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    eqn[i][j] = in.nextInt();
                }
            }
            int q = in.nextInt();
            int x[] = new int[q];
            for (int i = 0; i < q; i++) {
                x[i] = in.nextInt();
            }

        }
    }
}
