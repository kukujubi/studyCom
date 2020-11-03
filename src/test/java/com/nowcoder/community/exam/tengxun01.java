package com.nowcoder.community.exam;

import java.util.*;
public class tengxun01 {
    public static void init(int n,int[] fa){
        for(int i=0;i<n;i++){
            fa[i]=i;
        }
    }
    public static int findfa(int x,int[] fa){
        int start=x;
        while(fa[start]!=start){
            start=fa[start];
        }
        while(fa[x]!=x){
            int temp=x;
            x=fa[x];
            fa[temp]=start;
        }
        return start;
    }
    public static void union(int a,int b,int[] fa){
        int fA=findfa(a,fa);
        int fB=findfa(b,fa);
        if(fA!=fB){
            fa[fA]=fB;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] fa = new int[n];
        init(n,fa);
        int x;
        for(int i=0;i<m;i++){
            int ge=in.nextInt();
            int start=in.nextInt();
            for(int j=2;j<=ge;j++){
                int cur=in.nextInt();
                union(start,cur,fa);
            }

        }
        int res=0;
        int f = findfa(0,fa);
        for(int i=0;i<n;i++){
            if(f==findfa(i,fa)){
                res++;
            }
        }
        System.out.print(res);
    }
}
