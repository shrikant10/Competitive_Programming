package Algorithms;

// Deciding the order of multiplication for matrices to minimize the number of operations
/*	            A	  B	    C
              [1x2]	[2x3]  [3x4]

              (AB)C	= 1x2x3 + 1x3x4 =6 + 12 = 18(Ans)

              A(BC)	= 24 + 8 = 32

*/


public class Matrix_Chain_Multiplication {

    static int MatrixChainOrder(int dim[], int n) {

        int DP[][] = new int[n][n];

        /*for (int i = 0; i < n; i++){                          // Already 0
            DP[i][i] = 0;
        }*/

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {           // i - lower index   j - upper index   k - partition point
                int j = i + L - 1;                          // L - diff btw upper and lower
                if (j == n) continue;
                DP[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {                          // Searching the best partition
                    int cost = DP[i][k] + DP[k + 1][j] + dim[i - 1] * dim[k] * dim[j];
                    if (cost < DP[i][j])
                        DP[i][j] = cost;
                }
            }
        }

        return DP[1][n - 1];
    }

    public static void main(String[] args) {
        int dim[] = new int[]{1, 2, 3, 4};      // 3 Matrix     [1x2]	[2x3]  [3x4]
        int size = dim.length;

        System.out.println(MatrixChainOrder(dim, size));
    }
}
