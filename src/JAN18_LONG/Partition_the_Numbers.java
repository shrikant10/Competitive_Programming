package JAN18_LONG;

import java.util.Scanner;

public class Partition_the_Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int n = in.nextInt();

            int s[] = new int[n + 1];
            long sum = (n * ((long) n + 1)) / 2 - x;

            if (n <= 3 || sum % 2 != 0) {
                System.out.println("impossible");
                continue;
            }

            sum = sum / 2;
            s[x] = 2;
            for (int i = n; i > 0; i--) {
                if (i != x && sum - i >= 0 && sum-i!=x){
                    sum -= i;
                    s[i] = 1;
                }
                if(sum==0){
                    break;
                }
            }

            if (sum != 0) {
                System.out.println("impossible");
            }
            else {
                for (int i = 1; i <= n; i++) {
                    System.out.print(s[i]);
                }
                System.out.println();
            }
        }
    }
}