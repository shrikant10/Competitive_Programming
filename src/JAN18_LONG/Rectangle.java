package JAN18_LONG;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            if (a == b && c == d) {
                System.out.println("YES");
            } else if (a == c && b == d) {
                System.out.println("YES");
            } else if (a == d && b == c) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
