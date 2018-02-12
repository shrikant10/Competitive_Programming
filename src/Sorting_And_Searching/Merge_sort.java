package Sorting_And_Searching;

import java.util.Arrays;

public class Merge_sort {

    static void Merge(int a[], int l, int m, int r){
        int x = m-l+1;
        int y = r-m;

        int s_x[] = new int[x];
        int s_y[] = new int[y];

        for(int i=0; i<x; i++){
            s_x[i] = a[l+i];
        }

        for(int i=0; i<y; i++){
            s_y[i] = a[m+1+i];
        }

        int i =0; int j=0; int k = l;
        while(i<x && j<y){
            if(s_x[i]<s_y[j]){
                a[k++]=s_x[i];
                i++;
            }else{
                a[k++]=s_y[j];
                j++;
            }
        }

        while(i<x){
            a[k++]=s_x[i];
            i++;
        }

        while(j<y){
            a[k++]=s_y[j];
            j++;
        }
    }

    static void Sort(int a[], int l, int r){
        if(l<r){
            int m = (l+r)/2;
            Sort(a, l, m);
            Sort(a, m+1, r);
            Merge(a, l, m, r);
        }
    }


    public static void main(String[] args) {
        int a[] = {10, 40, 20, 90, 50, 20, 80, 100, 70, 0};
        Sort(a, 0, a.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(a));
    }
}