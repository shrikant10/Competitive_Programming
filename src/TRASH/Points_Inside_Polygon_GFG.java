package TRASH;

import java.util.Scanner;

class Points_Inside_Polygon_GFG {

    static int x_max;

    static boolean on_Segment(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x2 <= Math.max(x1, x3) && x2 >= Math.min(x1, x3)
                && y2 <= Math.max(y1, y3) && y2 >= Math.min(y1, y3))
            return true;
        return false;
    }

    static int orientation(int x1, int y1, int x2, int y2, int x3, int y3) {
        int val = (y2 - y1) * (x3 - x2) - (x2 - x1) * (y3 - y2);

        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    static boolean Intersect(int P_x1, int P_y1, int Q_x1, int Q_y1, int P_x2, int P_y2, int Q_x2, int Q_y2) {

        int o1 = orientation(P_x1, P_y1, Q_x1, Q_y1, P_x2, P_y2);
        int o2 = orientation(P_x1, P_y1, Q_x1, Q_y1, Q_x2, Q_y2);
        int o3 = orientation(P_x2, P_y2, Q_x2, Q_y2, P_x1, P_y1);
        int o4 = orientation(P_x2, P_y2, Q_x2, Q_y2, Q_x1, Q_y1);

        if (o1 != o2 && o3 != o4)
            return true;

        if (o1 == 0 && on_Segment(P_x1, P_y1, P_x2, P_y2, Q_x1, Q_y1)) return false;

        if (o2 == 0 && on_Segment(P_x1, P_y1, Q_x2, Q_y2, Q_x1, Q_y1)) return false;

        if (o3 == 0 && on_Segment(P_x2, P_y2, P_x1, P_y1, Q_x2, Q_y2)) return false;

        if (o4 == 0 && on_Segment(P_x2, P_y2, Q_x1, Q_y1, Q_x2, Q_y2)) return false;

        return false;
    }

    static boolean isInside(int x[], int y[], int n, int X, int Y) {

        int i = 0;
        int count = 0;
        do {
            int next = (i + 1) % n;

            if(on_Segment(x[i], y[i], X, Y, x[next], y[next]))
                return false;

            if (Intersect(x[i], y[i], x[next], y[next], X, Y, Integer.MAX_VALUE, Y)) {

                if (orientation(x[i], y[i], X, Y, x[next], y[next]) == 0)
                    return !on_Segment(x[i], y[i], X, Y, x[next], y[next]);

                count++;
            }
            i = next;
        } while (i != 0);

        return (count % 2 == 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a = n / 10;
            int x[] = new int[n];
            int y[] = new int[n];


            x_max = Integer.MIN_VALUE;
            int y_max = Integer.MIN_VALUE;
            int x_min = Integer.MAX_VALUE;
            int y_min = Integer.MAX_VALUE;


            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                if (x[i] > x_max) {
                    x_max = x[i];
                }
                if (x[i] < x_min) {
                    x_min = x[i];
                }
                if (y[i] > y_max) {
                    y_max = y[i];
                }
                if (y[i] < y_min) {
                    y_min = y[i];
                }
            }

            long ans[][] = new long[2][a];
            int k = 0;
            int m = 0;

            while (k < n - 2 && m < a) {
                for (int i = k + 2; i < n; i++) {
                    long _x = (long) x[i] + x[k];
                    long _y = (long) y[i] + y[k];
                    if (_x % 2 == 0 && _y % 2 == 0) {
                        ans[0][m] = _x / 2;
                        ans[1][m] = _y / 2;
                        m++;
                        if (m == a) {
                            break;
                        }
                    }
                }
                k++;
            }


            //if (m != a) {
                for (int X = x_min+1; X < x_max && m < a; X++) {
                    for (int Y = y_min+1; Y < y_max; Y++) {
                        if (isInside(x, y, n, X, Y)) {
                            ans[0][m] = X;
                            ans[1][m] = Y;
                            m++;
                            if (m == a) {
                                break;
                            }
                        }
                    }
                }
            //}

            if (m < a) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < a; i++) {
                    System.out.println(ans[0][i] + " " + ans[1][i]);
                }
            }

        }
    }
}
