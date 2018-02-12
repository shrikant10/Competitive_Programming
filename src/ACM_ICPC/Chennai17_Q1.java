package ACM_ICPC;

import java.util.Scanner;

public class Chennai17_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            String s = in.next();
            int u = 0;
            int l = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (Character.isLowerCase(c)) {
                    l++;
                } else
                    u++;
            }
            if (l <= k && u <= k) {
                System.out.println("both");
            } else if (l <= k) {
                System.out.println("brother");
            } else if (u <= k) {
                System.out.println("chef");
            } else {
                System.out.println("none");
            }
        }
    }
}
