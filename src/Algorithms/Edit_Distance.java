package Algorithms;

// Edit Distance Algorithm
// Aim - To convert String a into String B by
// 1> inserting     2> Removing     3>  Replacing
// and find the minimum no. of operations.


public class Edit_Distance {

    static int E_Dist(char a[], char b[], int m, int n) {

        int DP[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0) {                // First string is empty we need to add j elements
                    DP[i][j] = j;
                } else if (j == 0) {           // Second string is empty we need to remove i elements
                    DP[i][j] = i;
                } else if (a[i - 1] == b[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1];
                } else {
                    //Insert               //Remove      //Replace
                    DP[i][j] = 1 + Math.min(DP[i][j - 1], Math.min(DP[i - 1][j], DP[i - 1][j - 1]));
                }
            }
        }

        return DP[m][n];
    }

    public static void main(String[] args) {
        String a = "gedddek";
        String b = "geek";

        int m = a.length();
        int n = b.length();

        int res = E_Dist(a.toCharArray(), b.toCharArray(), m, n);
        System.out.println(res);

    }
}
