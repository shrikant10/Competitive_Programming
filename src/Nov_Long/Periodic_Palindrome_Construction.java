package Nov_Long;

import java.util.*;
import java.lang.*;

class Periodic_Palindrome_Construction {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            if (p <= 2) {
                System.out.println("impossible");
                continue;
            }
            int times = n / p;
            char sub[] = new char[p];
            Arrays.fill(sub, 'a');
            sub[p / 2] = 'b';
            if (p % 2 == 0) {
                sub[p / 2 - 1] = 'b';
            }
            String pal = new String(sub);
            System.out.print(pal);
            for (int i = 1; i < times; i++) {
                System.out.print(pal);
            }
            System.out.println();
        }
    }
}