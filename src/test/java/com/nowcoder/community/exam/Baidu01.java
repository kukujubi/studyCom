package com.nowcoder.community.exam;

import java.util.*;
public class Baidu01 {
    public static int find(int[] a ,int v){
        int low=0;
        int high=a.length-1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid]>=v){
                if(mid==0||a[mid-1]<v){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int t1=0;
        while(t1<t){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] ban = new int[n];
            for(int i=0;i<n;i++){
                ban[i]=in.nextInt();
            }
           int[] jue = new int[m];
            for(int i=0;i<m;i++){
                jue[i] = in.nextInt();
            }
            Arrays.sort(jue);
            for(int j=0;j<n;j++){
                int index = find(jue,ban[j]);
                if(index ==-1){
                    index=0;
                }
                else{
                    index = m-index;
                }
                System.out.print(index+" ");
            }
            System.out.println();


            t1++;
        }
    }
}