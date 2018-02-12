package BACK_TRACKING;

import java.util.Arrays;

public class The_Knights_Tour_Problem {
    static int N = 8;

    static int x_move[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int y_move[] = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean isSafe(int chess[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && chess[x][y] == -1);
    }

    static boolean solve(int chess[][], int x, int y, int move) {

        if (move == N * N) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int n_x = x + x_move[k];
            int n_y = y + y_move[k];
            if (isSafe(chess, n_x, n_y)) {
                chess[n_x][n_y] = move;
                if (solve(chess, n_x, n_y, move + 1)) {
                    return true;
                } else {
                    chess[n_x][n_y] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int chess[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(chess[i], -1);
        }

        chess[0][0] = 0;
        if (!solve(chess, 0, 0, 1)) {
            System.out.println("No Solution Exist");
        } else {
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(chess[i]));
            }
        }

    }
}
