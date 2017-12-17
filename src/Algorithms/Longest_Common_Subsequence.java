package Algorithms;


public class Longest_Common_Subsequence {

    static int LCS(char a[], char b[], int m, int n) {
        int L[][] = new int[m + 1][n + 1];              // All elements will be initially 0

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

    public static void main(String args[]) {
        String a = "ABCDEF";
        String b = "ABFGR";

        int m = a.length();
        int n = b.length();

        int res = LCS(a.toCharArray(), b.toCharArray(), m, n);
        System.out.println(res);
    }
}
