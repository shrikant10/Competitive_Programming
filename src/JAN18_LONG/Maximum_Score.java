package JAN18_LONG;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Maximum_Score {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a[][] = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j] = in.nextInt();
                }
            }
            long sum = 0;
            int max;
            int e = Integer.MAX_VALUE;
            for(int i=n-1; i>=0; i--){
                max = 0;
                for(int j=0; j<n; j++){
                    if(a[i][j]>max && a[i][j]<e){
                        max=a[i][j];
                    }
                }
                if(max==0){
                    sum=-1;
                    break;
                }
                sum+=max;
                e = max;
            }
            System.out.println(sum);
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

    }
}