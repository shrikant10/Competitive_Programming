package FEB_18;

import java.util.Scanner;

public class Chef_And_His_Characters {

    static boolean check(String s) {
        if (s.contains("c") && s.contains("h") && s.contains("e") && s.contains("f")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            int n = s.length();
            long count = 0;
            if (n < 4) {
                System.out.println("normal");
                continue;
            }
            for (int i = 0; i < n - 3; i++) {
                if (check(s.substring(i, i + 4))) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("normal");
            } else{
                System.out.println("lovely "+count);
            }
        }
    }
}
