package FEB_18;

import java.util.Arrays;
import java.util.Scanner;

public class Chef_And_Odd_Queries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int l[] = new int[n];
            int r[] = new int[n];
            for(int i=0;i<n;i++){
                l[i]=in.nextInt();
                r[i]=in.nextInt();
            }
            int q = in.nextInt();
            while (q-- > 0){
                int m = in. nextInt();
                int a[] = new int[m];
                for(int i=0;i<m;i++){
                    a[i]=in.nextInt();
                }
                int good = 0;
                for(int i=0;i<n;i++){
                    int count = 0;
                    for(int j=0; j<m; j++){
                        if(a[j]>=l[i] && a[j]<=r[i]){
                            count++;
                        }
                    }
                    if(count%2!=0){
                        good++;
                    }
                }
                System.out.println(good);
            }
        }
    }
}
