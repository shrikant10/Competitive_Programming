package FEB_18;

import java.util.Scanner;

public class Chef_And_His_Patents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            if(k<n){
                System.out.println("no");
                continue;
            }

            int o = 0;
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == 'O') {
                    o++;
                }
            }
            int e = k - o;

            int i = 1;
            int p = 0;          // p - max num of patents that can be done

            while (i <= m ) {
                if (i % 2 != 0 && o>0) {
                    p+=Math.min(o,x);
                    o-=x;
                }
                else if(i%2 == 0 && e>0){
                    p+=Math.min(e,x);
                    e-=x;
                }
                i++;
            }

            if (n <= p) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
