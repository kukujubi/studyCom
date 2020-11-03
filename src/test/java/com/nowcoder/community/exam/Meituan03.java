package com.nowcoder.community.exam;
import java.util.*;
public class Meituan03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String a = in.nextLine();
        String t = in.nextLine();
        String s = in.nextLine();
       if(n<m) {
           System.out.println("No");
           return;
       }
       int ss = 0;
       int res=0;
       for(int i =0;i<n;i++) {
           if (t.charAt(i) == s.charAt(ss)) {
               res+=i+1;
               ss++;
               if (ss == m) {
                   System.out.println("Yes");
                   System.out.println(res);
                   return;
               }
           }
       }
       if(ss!=m) {
           System.out.println("No");
       }


       // char[] tt = t.toCharArray();

//        HashMap<String,Integer> map = new HashMap<>();
//        process("",0,tt,s,0,map);
//        if(map.size()==0){
//            System.out.println("No");
//        }
//        else{
//            int res=Integer.MAX_VALUE;
//
//            for(Map.Entry<String,Integer> entry:map.entrySet()){
//                if(entry.getValue()<res){
//                    res=entry.getValue();
//                }
//            }
//            System.out.println("Yes");
//            System.out.println(res);
//        }
//    }
//    public static void process(String sub,int index,char[] tt,String s,int res,HashMap<String,Integer> map){
//        if (index == tt.length){
//            if (sub.equals(s)){
//                map.put("Yes",res);
//                return;
//            }
//            else
//                return ;
//        }
//        process(sub,index+1,tt,s,res,map);
//        process(sub+tt[index],index+1,tt,s,res+index+1,map);

    }
}
