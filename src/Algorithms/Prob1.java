package Algorithms;

import java.util.*;
import java.io.*;
class Prob1 {

    public static int binarysearch(int i,int j,long[] a,long m,int c){

        //System.out.println(i+" "+j);
        if(i>j)
            return j;

        int mid=(i+j)/2;
        //System.out.println(mid);
        if(c==0){

            if(a[i-1]<m && a[i]>m)
                return i-1;
        }
        if(c==1){

            //System.out.println(a[i+1]+"             "+a[i]+"           "+m);
            if(a[i+1]>m && a[i]<m) {
                return i;
            }
        }
        if(a[mid]<m){

            return binarysearch(mid+1,j,a,m,0);
        }
        else if(a[mid]>m){

            return binarysearch(i,mid-1,a,m,1);
        }
        else{
            int p=a.length-1;

            for(int k=mid;k<a.length;k++){

                if(a[k]>m){

                    p=k-1;
                    break;
                }
            }

            return p;
        }
    }

    public static void main(String[] args) {

        InputReader in=new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int te=in.nextInt();
        long mod= 1000000007 ;

        while(te-->0){

            long sum=0;
            int p=in.nextInt();
            int q=in.nextInt();
            int r=in.nextInt();

            long a[]=new long[p+1];
            long b[]=new long[q+1];
            long c[]=new long[r+1];

            for(int i=1;i<=p;i++)
                a[i]=in.nextLong();

            for(int i=1;i<=q;i++)
                b[i]=in.nextLong();

            for(int i=1;i<=r;i++)
                c[i]=in.nextLong();

            Arrays.sort(a);
            Arrays.sort(c);

            long sa[]=new long[p+1];
            long sc[]=new long[r+1];

            for(int i=1;i<=p;i++){


                    sa[i]=sa[i-1]+a[i];

            }

            for(int i=1;i<=r;i++){


                    sc[i]=sc[i-1]+c[i];
            }
            long ans=0;
            for(int i=1;i<=q;i++){
                //System.out.println(a.length);
                ans=0;
                int j=binarysearch(1,p,a,b[i],-1);
                int k=binarysearch(1,r,c,b[i],-1);

                ans+=((j * b[i]) % mod + sa[j] % mod) % mod
                        * ((k * b[i]) % mod + sc[k] % mod) % mod;
                sum+=ans%mod;
            }

            out.println(sum%mod);
            out.flush();
        }
    }
}


class InputReader
{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream)
    {
        this.stream = stream;
    }

    public int read()
    {
        if (numChars==-1)
            throw new InputMismatchException();

        if (curChar >= numChars)
        {
            curChar = 0;
            try
            {
                numChars = stream.read(buf);
            }
            catch (IOException e)
            {
                throw new InputMismatchException();
            }

            if(numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String nextLine()
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
    public int nextInt()
    {
        int c = read();

        while(isSpaceChar(c))
            c = read();

        int sgn = 1;

        if (c == '-')
        {
            sgn = -1;
            c = read();
        }

        int res = 0;
        do
        {
            if(c<'0'||c>'9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));

        return res * sgn;
    }

    public long nextLong()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read();
        }
        long res = 0;

        do
        {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }

    public double nextDouble()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.')
        {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.')
        {
            c = read();
            double m = 1;
            while (!isSpaceChar(c))
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public String readString()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do
        {
            res.appendCodePoint(c);
            c = read();
        }
        while (!isSpaceChar(c));

        return res.toString();
    }

    public boolean isSpaceChar(int c)
    {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next()
    {
        return readString();
    }

    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
}