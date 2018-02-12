
import java.util.Scanner;

class Matrix {


    static void set_neib(int a[][], int i, int j, int n, int m, boolean mark[][]) {
        int value = a[i][j];
        mark[i][j] = true;
        if (value == 0) {
            return;
        }
        if (i < n && a[i + 1][j] <= a[i][j]-1 && a[i+1][j]!=-1) {
            a[i + 1][j] = value - 1;
            set_neib(a, i + 1, j, n, m, mark);
        }

        if (i > 1 && a[i - 1][j] <= a[i][j]-1 && a[i-1][j]!=-1) {
            a[i - 1][j] = value - 1;
            set_neib(a, i - 1, j, n, j, mark);
        }

        if (j < m && a[i][j + 1] <= a[i][j]-1 && a[i][j+1]!=-1) {
            a[i][j + 1] = value - 1;
            set_neib(a, i, j + 1, n, m, mark);
        }

        if (j > 1 && a[i][j - 1] <= a[i][j]-1 && a[i][j-1]!=-1) {
            a[i][j - 1] = value - 1;
            set_neib(a, i, j - 1, n, m, mark);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a[][] = new int[n + 1][m + 1];
            boolean mark[][] = new boolean[n + 1][m + 1];

            int k = 0;
            int start[][] = new int[2][n*m];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = in.nextInt();
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if(a[i][j]>0){
                        set_neib(a, i, j, n, m, mark);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (a[i][j] == -1) {
                        System.out.print("B");
                    } else if (mark[i][j] == true) {
                        System.out.print("Y");
                    } else {
                        System.out.print("N");
                    }
                }
                System.out.println();
            }

        }
    }
}