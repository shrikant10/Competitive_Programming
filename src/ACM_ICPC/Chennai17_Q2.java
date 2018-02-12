package ACM_ICPC;

import java.util.Scanner;

public class Chennai17_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int freq[] = new int[4];
            while(n-->0){
                String s = in.next();
                if(s.equals("a") || s.equals("aa")){
                    freq[0]++;
                } else if(s.equals("b") || s.equals("bb")){
                    freq[1]++;
                } else if(s.equals("ab")){
                    freq[2]++;
                } else if(s.equals("ba")){
                    freq[3]++;
                }
            }
            long ans = 0;
            if(freq[2]>0 || freq[3]>0){
                if(freq[2]==0){
                    ans=freq[3]*2;
                }
                else if(freq[3]==0){
                    ans=freq[2]*2;
                }
                else if(freq[2]>freq[3]){
                    ans+=freq[3]*2+1;
                    ans++;
                    freq[2]-=freq[3]+1;
                    ans+=freq[2]*2;
                }
                else if(freq[2]<freq[3]){
                    ans+=freq[2]*2+1;
                    ans++;
                    freq[3]-=freq[2]+1;
                    ans+=freq[3]*2;
                }
                else{
                    ans+=freq[2]*2+1;
                }
            }
            else{
                if(freq[1]==0 || freq[0]==0){
                    ans = 1;
                }else {
                    ans = 2;
                }
            }
            System.out.println(ans);
        }
    }
}
