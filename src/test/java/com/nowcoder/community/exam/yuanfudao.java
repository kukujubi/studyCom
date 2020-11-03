package com.nowcoder.community.exam;

//逆时针打印完全二叉树边界
import java.util.*;
public class yuanfudao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int index = 0;
        while (index<n) {
           arr[index++] = sc.nextInt();
        }
        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        res.add(arr[0]);
        Stack<Integer> stack = new Stack<>();
        while(left<n){

            right = right*2+2;
            if (right<n){
                stack.push(right);
            }
            left = left*2+1;
            if (left<n){
            res.add(arr[left]);}
        }

        int lastLeft1=(left-1)/2+1;
        while (lastLeft1<n){
            res.add(arr[lastLeft1++]);
        }

        int lastLeft2 = (n-2)/2+1;
        int lastright =stack.pop();
        while (lastLeft2<=lastright){
            res.add(arr[lastLeft2++]);
        }

       while(!stack.isEmpty()){
           res.add(arr[stack.pop()]);
       }
       for(Integer value:res){
           System.out.print(value+" ");
       }

    }
}
