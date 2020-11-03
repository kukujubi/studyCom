package com.nowcoder.community.exam;

import java.util.HashSet;

public class shopee01 {
    public static void main(String[] args){
        String str="adc";
        int res=0;
        for(int i=0;i<str.length()-1;i++){
            for(int j=i;j<str.length()-1;j++){
                String cur = str.substring(i,j+1);
                HashSet<Character> set = new HashSet<>();
                for(int t=0;t<cur.length();t++){
                    set.add(cur.charAt(t));
                }
                int count=0;
                for(int k=j+1;k<str.length();k++){
                    if(!set.contains(str.charAt(k))){
                        count++;
                        res=Math.max(res,cur.length()*count);
                        continue;
                    }

                    count=0;


                }
            }
        }

        System.out.println(res);
    }
}
