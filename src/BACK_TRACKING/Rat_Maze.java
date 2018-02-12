package BACK_TRACKING;

import java.util.Arrays;

public class Rat_Maze {
    static int N = 4;

    static boolean isSafe(int maze[][], int x, int y){
        return (x>=0 && x<N && y>=0 && y<N && maze[x][y]==1);
    }

    static boolean solve(int maze[][], int path[][], int x, int y){

        path[x][y]=1;
        if(x==N-1 && y== N-1){
            return true;
        }
        if(isSafe(maze, x+1,y)){
            if(solve(maze, path, x+1, y)){
                return true;
            }
        }
        if(isSafe(maze, x,y+1)){
            if(solve(maze, path, x, y+1)){
                return true;
            }
        }
        path[x][y]=0;
        return false;
    }

    public static void main(String[] args) {

        int maze[][] = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int path[][] = new int[N][N];

        if (!solve(maze, path, 0, 0)) {
            System.out.println("No Solution Exist");
        } else {
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(path[i]));
            }
        }
    }
}
