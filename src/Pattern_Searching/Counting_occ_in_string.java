package Pattern_Searching;

import java.util.Scanner;

public class Counting_occ_in_string {

    static void count_simple(String str){
        boolean check = false;
        char ch[] = str.toCharArray();
        int n = str.length();
        int count=0;
        for(int i = 0; i<n;i++){
            if(ch[i]=='1' && !check){
                check=true;
            }
            else if (ch[i]!='0' && ch[i]!='1'){
                check=false;
            }
            else if(ch[i]=='1' && check){
                if(ch[i-1]=='0')
                    count++;
            }
        }
        System.out.println(count);
    }

    static void count_simple2(String str){
        char ch[] = str.toCharArray();
        int n = str.length();
        int count=0;

        char last = ch[0];
        int i=1;
        while (i<n){
            if(ch[i]=='0' && last == '1'){
                while (ch[i]=='0'){
                    i++;
                }
                if(ch[i]=='1'){
                    count++;
                }
            }
            last=ch[i];
            i++;
        }

        System.out.println(count);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        count_simple(str);
        count_simple2(str);
        //count_reg(str);
    }

}
