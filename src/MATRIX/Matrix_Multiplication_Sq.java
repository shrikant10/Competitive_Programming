package MATRIX;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Multiplication_Sq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the order: ");
        int n = in.nextInt();

        int a[][] = new int[n][n];
        int b[][] = new int[n][n];

        int mul[][] = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }

        System.out.println("Enter Matrix 1: ");
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                b[i][j]=in.nextInt();
            }
        }
        System.out.println("Enter Matrix 2: ");
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    mul[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        System.out.println("Resultant Matrix: ");
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(mul[i]));
        }
    }
}
