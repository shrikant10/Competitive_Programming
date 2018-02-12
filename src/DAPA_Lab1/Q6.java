package DAPA_Lab1;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = in.nextInt();
        int a[] = new int[n];
        int max = Integer.MIN_VALUE;
        System.out.println("Enter the elements: ");
        for(int i=0; i<n; i++){
            a[i]=in.nextInt();
            if(a[i]>max){
                max = a[i];
            }
        }
        int freq[] = new int[max+1];
        for(int i=0;i<n;i++){
            freq[a[i]]++;
        }
        int ans=0;
        int count =0;
        for(int i=0;i<max;i++){
            if(freq[i]>count){
                ans=i;
                count=freq[i];
            }
        }
        System.out.println("Element which occurs most number of times: "+ans);
    }
}
