package FEB_18;

import java.util.Scanner;

public class Permutaion_And_Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            int n = s.length();

            // Count the freq of each alphabet
            int f[] = new int[26];
            for (int i = 0; i < n; i++) {
                int temp = s.charAt(i) - 97;
                f[temp]++;
            }

            //Num of alphabet with odd freq shouldn't be more than 1
            int mid = -1;
            for (int i = 0; i < 26; i++) {
                if (f[i] % 2 != 0) {
                    if (mid != -1) {
                        mid = -2;
                        break;
                    } else {
                        mid = i;
                    }
                }
            }

            if (mid == -2) {
                System.out.println(-1);
                continue;
            }

            int pos[] = new int[n];

            if (mid != -1) {
                pos[n / 2] = s.lastIndexOf((char) (mid + 97)) + 1;
                f[mid]--;
            }

            char c;
            int k = 0;
            int p;
            for (int i = 0; i < 26; i++) {
                p = -1;
                while (f[i] > 0) {
                    c = (char) (i + 97);
                    p = s.indexOf(c, p + 1);
                    pos[k] = p + 1;
                    p = s.indexOf(c, p + 1);
                    pos[n - 1 - k] = p + 1;
                    k++;
                    f[i] -= 2;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(pos[i] + " ");
            }
            System.out.println();
        }
    }
}