package com.nowcoder.community.exam;

import java.util.*;
public class Tianye0911 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        HashSet<Integer> set= new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> shangXia=new HashSet<>();
        int index = 0;
        int imp=-1;
        while(index<m){
            int hao = in.nextInt();
            int ban = in.nextInt();
            if(m==1){
                    for (int i=1;i<=n;i++){
                        System.out.print(i+" ");
                    }
                    return;
            }
            if(index==0&&ban==1){
                imp=hao;
            }
            if (index==m-1&&hao==imp&&ban==0&&shangXia.size()==1&&shangXia.contains(hao)){
               //其他的上了班的也要下了班？
                res.add(hao);
            }
            if(!set.contains(hao)){
                set.add(hao);
            }
            if (shangXia.contains(hao)){
                shangXia.remove(hao);
            }
            else{
                shangXia.add(hao);
            }
            index++;
        }
        for(int i=1;i<=n;i++){
            if (!set.contains(i)){
                res.add(i);
            }
        }
        for(Integer v:res){
            System.out.print(v+" ");
        }

    }
}
