package com.nowcoder.community.exam;

import java.util.*;
public class Pinduoduo01 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        int index = 0;
        while (index < m) {
            arr[index++]=in.nextInt();
        }
        int zui = 0;
        for(int i=0;i<m-1;i++) {
            for (int j = i+1; j < m ; j++) {
                int temp = lcm(arr[i], arr[j]);
                while (temp <= n) {
                        zui++;
                        temp=temp*2;
                }
            }
        }
        int count =0;
        for (int i = 0;i<m;i++){
            count+=n/arr[i];
        }
        count = count - zui;
        System.out.println(count);
    }
    public static int lcm(int p, int q) {
        int p1 = p;
        int q1 = q;

        while (q != 0) {
            int r = p % q;
            p = q;
            q = r;
        }
        return (p1 * q1) / p;
    }
}
