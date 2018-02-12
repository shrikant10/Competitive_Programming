package MATRIX;

import java.util.Scanner;

public class Matrix_Determinent {
    static int[][] Cofactor(int m[][], int x, int y, int n){
        int i=0;
        int j=0;
        int temp[][] = new int[n][n];
        for(int r = 0; r<n; r++){
            for (int c =0; c<n; c++){
                if (r != x && c != y)
                {
                    temp[i][j++] = m[r][c];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        return temp;
    }

    static int Determinant(int a[][], int n){
        int D = 0;
        if(n==1)
            return a[0][0];


        int sign = 1;

        for (int i = 0; i < n; i++)
        {
            int temp[][] = Cofactor(a, 0, i, n);
            D += sign * a[0][i] * Determinant(temp, n - 1);
            sign = -sign;
        }
        return D;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the order: ");
        int n = in.nextInt();

        int a[][] = new int[n][n];
        System.out.println("Enter Matrix: ");

        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }

        int res = Determinant(a,n);
        System.out.println("Determinant : "+res);
    }
}
