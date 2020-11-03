package com.nowcoder.community.exam;
import java.util.*;
public class Huawei {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        int length = str.length();
        if(length<7){
            System.out.println(0);
            return;
        }
        if((length-3)%4!=0){
            System.out.println(0);
            return;
        }
        int n = (length+1-4)/4;


        int[] kuan = new int[n];
        int[] gao=new int[n];
        int index=0;
        for(int i=0;i<2*n+2;i++){
            char cur = str.charAt(i);
            if(cur=='['||cur==','||cur==']'){
                continue;
            }
            if(cur-'0'<=0){
                System.out.print(0);
                return;
            }
            kuan[index++]=cur-'0';
        }
        index=0;
        for(int i=2*n+2;i<str.length();i++){
            char cur = str.charAt(i);
            if(cur=='['||cur==','||cur==']'){
                continue;
            }
            if(cur-'0'<=0){
                System.out.print(0);
                return;
            }
            gao[index++]=cur-'0';
        }
        int res=gao[0]*kuan[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int curGao=gao[0];
        for(int i=1;i<n;i++){
            if(stack.isEmpty()){
                res=Math.max(res,gao[i]*kuan[i]);
                stack.push(i);
                continue;
            }
            if(gao[i]>gao[stack.peek()]){
                stack.push(i);
                continue;
            }
            else if(gao[i]==gao[stack.peek()]){
                continue;
            }
            else {

                while(!stack.isEmpty()&&gao[i]<gao[stack.peek()]){
                    int right = i - 1;
                    int cal=stack.pop();
                    int left=stack.isEmpty()?-1:stack.peek();

                    int temp=0;
                    while(right!=left){
                        temp+=kuan[right--];
                    }
                    res=Math.max(res,(temp*gao[cal]));

                }

                stack.push(i);
            }


        }
        if (stack.isEmpty()){
            System.out.print(res);}
        else
        {
            while(!stack.isEmpty()){
                int cal=stack.pop();
                int right=n-1;
                int left = stack.isEmpty()?-1:stack.peek();
                int temp=0;
                while (right != left) {
                    temp += kuan[right--];
                }
                res = Math.max(res, (temp * gao[cal]));
            }
            System.out.println(res);
        }
    }
}