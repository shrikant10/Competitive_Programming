package Algorithms;

public class Min_Cost_Path {

    static int MCP(int cost[][], int m, int n) {

        int DP[][] = new int[m + 1][n + 1];

        DP[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++) {                     //First column can be only filled with values from top
            DP[i][0] = DP[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j <= n; j++) {                     //First row can be only filled with values from left
            DP[0][j] = DP[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                DP[i][j] = cost[i][j] + Math.min(DP[i - 1][j - 1], Math.min(DP[i - 1][j], DP[i][j - 1]));
            }
        }
        return DP[m][n];
    }

    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        int res = MCP(cost, 2, 2);
        System.out.println(res);
    }
}
