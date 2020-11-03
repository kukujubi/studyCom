package com.nowcoder.community.exam;

public class Huawei01 {
    public static void main(String[] args){
        String s1="aab";
        String s2="c*a*b";
        System.out.println(process(s1,s2,0,0));
    }
    public static boolean process(String s1,String s2,int i,int j){
        if (j==s2.length()){
            return i==s1.length();
        }


            if (j<s2.length()-1&&s2.charAt(j+1)=='*'&&i<s1.length()) {
                return process(s1, s2, i, j + 2) || process(s1, s2, i + 1, j + 2)
                        || process(s1,s2,i+1,j);
            }
            else{
                if(i<s1.length()&&(s2.charAt(j)==s1.charAt(i)||s2.charAt(j)=='.')){
                    return process(s1,s2,i+1,j+1);
                }
                return false;
            }

            }




}
