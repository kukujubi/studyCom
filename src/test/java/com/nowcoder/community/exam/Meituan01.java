package com.nowcoder.community.exam;
import java.util.*;
public class Meituan01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int res = 0;
        while(m<=n){
            if(find (m)){
                res++;
            }
            m++;
        }
        System.out.println(res);

    }
    public static boolean find(int n){
        int f = n%10;
        int e = (n/10)%10;
        if(e==0||e==f)
            return false;
        int d = (n/100)%10;
        if(d==e||d==f)
            return false;
        int c = (n/1000)%10;
        if(c==0||c==f||c==e||c==d)
            return false;
        int b = (n/10000)%10;
        if(b==f||b==e||b==d||b==c)
            return false;
        int a = (n/100000)%10;
        if(a==0||a==b||a==c||a==d||a==e||a==f)
            return false;

        if(a*10+b+c*10+d==e*10+f)
            return true;
        return false;
    }
}
