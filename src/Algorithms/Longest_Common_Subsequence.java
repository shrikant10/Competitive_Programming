package Algorithms;


public class Longest_Common_Subsequence {

    // Function to return the Length of Longest Common Subsequence
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


    // Function to return the Longest Common Subsequence
    static char[] LCS_String(char a[], char b[], int m, int n) {
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
        int index = L[m][n];
        char seq[] = new char[index];
        int i = m;
        int j = n;
        while(i>0 && j>0){
            if(a[i-1]==b[j-1]){
                seq[--index]=a[i-1];
                i--;
                j--;
            }
            else if(L[i-1][j]>L[i][j-1])
                i--;
            else
                j--;
        }
        return seq;
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
