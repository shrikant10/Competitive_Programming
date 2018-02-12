package JAN18_LONG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K_Concatenation {

    static long kadane_maxsum_subarray(int a[], int size) {
        long sum = 0;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += a[i];
            if (sum > ans) {
                ans = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            long ans = 0;
            int na[] = new int[2*n];
            boolean neg = false;
            long nsum = 0;
            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] < 0) {
                    neg = true;
                }
                nsum += a[i];
            }
            if (!neg) {
                ans = nsum * k;
                System.out.println(ans);
                continue;
            }

            for (int i = 0; i < n; i++) {
                na[i] = a[i];
                na[n + i] = a[i];
            }

            sum1 = kadane_maxsum_subarray(a, n);
            sum2 = kadane_maxsum_subarray(na, 2 * n);
            long add = 0;
            for(int i=0;i<n;i++){
                if(a[i]<0){
                    add+=a[i];
                }else{
                    break;
                }
            }

            for(int i=n-1;i>=0;i--){
                if(a[i]<0){
                    add+=a[i];
                }else{
                    break;
                }
            }

            if (k == 1) {
                ans = sum1;
            } else if (nsum <= 0) {
                ans = sum2;
            } else {
                ans = Math.max(sum2, nsum * k - add);
            }
            System.out.println(ans);
        }
    }

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

        int[] array(int n) {
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = this.nextInt();
            }

            return a;
        }

        int[][] array(int n, int m) {
            int a[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    a[i][j] = this.nextInt();
            }

            return a;
        }
    }
}
