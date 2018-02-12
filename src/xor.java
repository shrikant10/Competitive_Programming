import java.util.Scanner;

public class xor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        long l = a[0];
        for(int i=1;i<n;i++){
            l = l^a[i];
        }
        if(l==0){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}