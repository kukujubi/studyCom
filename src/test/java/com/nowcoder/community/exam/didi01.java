package com.nowcoder.community.exam;

import java.util.*;

public class didi01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       List<Integer> list =new ArrayList<>();
       for(int a=1;a<=9;a++){
           for (int b=0;b<=9;b++){
               if (b==a){
                   continue;
               }
               for (int c=0;c<=9;c++){
                   if (c==b||c==a){
                       continue;
                   }
                   int abc=a*100+b*10+c;
                   int acc=a*100+c*10+c;
                   if (abc+acc==n){
                      list.add(abc);
                   }
               }
           }
       }
       if (list.size()==0){
           System.out.println(0);
       }
       else{
           System.out.println(list.size());
           Collections.sort(list);
           for(Integer value:list){
               System.out.println(value+" "+(n-value));
           }

       }


    }

}
