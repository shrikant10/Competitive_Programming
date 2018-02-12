package Algorithms;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

public class  Longest_Increasing_Subsequence {

    static int cal_lis(int arr[], int n) {
        int lis[] = new int[n + 1];   // 1 based indexing
        Arrays.fill(lis, 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int MAX = 0;
        for (int i = 1; i <= n; i++) {
            if (lis[i] > MAX) {
                MAX = lis[i];
            }
        }
        return MAX;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n + 1];   // 1 based indexing
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        int res = cal_lis(arr, n);
        System.out.println(res);
    }
}
