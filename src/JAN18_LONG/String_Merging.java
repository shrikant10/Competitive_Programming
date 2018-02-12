package JAN18_LONG;

import java.util.Scanner;

public class String_Merging {

    static int LCS(char a[], char b[], int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    static String Compress_Duplicate(char a[], int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n-1; i++){
            if(a[i]!=a[i+1]){
                sb.append(a[i]);
            }
        }
        sb.append(a[n-1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            String a = in.next();
            String b = in.next();

            String c_a = Compress_Duplicate(a.toCharArray(),n);
            String c_b = Compress_Duplicate(b.toCharArray(),m);

            n = c_a.length();
            m = c_b.length();

            int res = LCS(c_a.toCharArray(),c_b.toCharArray(),n,m);
            int ans = n+m-res;

            System.out.println(ans);

        }
    }
}
