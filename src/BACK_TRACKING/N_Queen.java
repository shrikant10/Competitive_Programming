package BACK_TRACKING;

import java.util.Arrays;
import java.util.HashSet;

public class N_Queen {
    static int N = 4;

    static boolean isSafe(int chess[][], int r, int c){
        for(int i=0;i<c;i++){
            if(chess[r][i]==1){
                return false;
            }
        }
        for(int i=1;i<=r&&i<=c;i++){
            if(chess[r-i][c-i]==1){
                return false;
            }

        }for(int i=1;i+r<N&&i<=c;i++){
            if(chess[r+i][c-i]==1){
                return false;
            }
        }
        return true;
    }

    static boolean solve(int chess[][], int c){

        if(c==N){
            return true;
        }
        for(int r=0; r<N; r++){
            if(isSafe(chess,r,c)){
                chess[r][c]=1;
                if(solve(chess,c+1)){
                    return true;
                }
                else{
                    chess[r][c]=0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int chess[][] = new int[N][N];

        if (!solve(chess, 0)) {
            System.out.println("No Solution Exist");
        } else {
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(chess[i]));
            }
        }
    }
}
