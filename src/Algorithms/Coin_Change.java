package Algorithms;

public class Coin_Change {

    static int change(int coin[], int len, int n) {
        int DP[] = new int[n + 1];
        DP[0] = 1;

        for (int i = 0; i < len; i++) {
            int amt = coin[i];
            while (amt <= n) {
                DP[amt] += DP[amt - coin[i]];
                amt++;
            }
        }

        return DP[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int coin[] = {2, 5, 3, 6};

        int res = change(coin, 4, n);
        System.out.println(res);
    }
}
