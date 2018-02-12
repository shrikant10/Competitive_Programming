package MATRIX;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Multiplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the order: ");
        int m1 = in.nextInt();
        int m2 = in.nextInt();
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        if(m2!=n1){
            System.out.println("Multiplication Not Possible");
            System.exit(0);
        }

        int a[][] = new int[m1][m2];
        int b[][] = new int[n1][n2];

        int mul[][] = new int[m1][n2];
        System.out.println("Enter Matrix 1: ");
        for(int i =0;i<m1;i++){
            for(int j=0;j<m2;j++){
                a[i][j]=in.nextInt();
            }
        }
        System.out.println("Enter Matrix 2: ");
        for(int i =0;i<n1;i++){
            for(int j=0;j<n2;j++){
                b[i][j]=in.nextInt();
            }
        }
        for(int i =0;i<m1;i++){
            for(int j=0;j<n2;j++){
                for(int k=0;k<m2;k++){
                    mul[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        System.out.println("Resultant Matrix: ");
        for(int i=0;i<m1;i++){
            System.out.println(Arrays.toString(mul[i]));
        }
    }
}
