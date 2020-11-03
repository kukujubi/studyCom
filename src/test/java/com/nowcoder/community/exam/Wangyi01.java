package com.nowcoder.community.exam;
import java.util.*;
public class Wangyi01 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        int length = str.length();
//        int[] arr = new int[1 << 6];
//        Arrays.fill(arr,-1);
//        int res=0;
//        int sta=0;
//        arr[0]=0;
//        for(int i=0;i<length;i++){
//            char cur = str.charAt(i);
//            if(cur == 'a'){
//                sta^=(1<<0);
//
//            }
//            else if(cur == 'b'){
//                sta^=(1<<1);
//            }
//            else if(cur == 'c'){
//                sta^=(1<<2);
//            }
//            else if(cur == 'x'){
//                sta^=(1<<3);
//            }
//            else if(cur == 'y'){
//                sta^=(1<<4);
//            }
//            else if(cur == 'z'){
//                sta^=(1<<5);
//            }
//            if (arr[sta]>=0){
//                res=Math.max(res,i+1-arr[sta]);
//            }
//            else{
//                arr[sta]=i+1;
//            }
//        }
//        System.out.print(res);
        public static boolean dfs(int[][] map,boolean[] used,int[] linked,int start,int m){
            for(int i=0;i<m;i++){
                if(used[i]==false && map[start][i]==1){
                    used[i]=true;
                    if(linked[i]==-1||dfs(map,used,linked,linked[i],m)){
                        linked[i]=start;
                        return true;
                    }
                }
            }
            return false;
        }
        public static int max(int[][] map,int m,int n){
            int count =0;
            int[] linked = new int[m];
            for(int i=0;i<m;i++){
                linked[i]=-1;
            }
            for(int i=0;i<n;i++){
                boolean[] used=new boolean[m];
                if(dfs(map,used,linked,i,m))
                    count++;
            }
            return count;

        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s1 = in.nextLine();
            String[] s11=s1.split(" ");
            int n = s11.length;
            int[] boy = new int[n];
            for(int i=0;i<n;i++){
                boy[i]=Integer.parseInt(s11[i++]);
            }
            String s2=in.nextLine();
            String[] s22=s2.split(" ");

            int m=s22.length;
            int[] girl = new int[m];
            for(int i=0;i<m;i++){
                girl[i]=Integer.parseInt(s22[i++]);
            }
            int k = in.nextInt();
            int[][] map = new int[1000][1000];
            int index =0;
            while(index < k){
                int b = in.nextInt();
                int g = in.nextInt();
                map[b][g]=1;

                index++;
            }
       /* int res =n>=m?m:n;
        res=Math.min(res,k/2);*/
            System.out.print(max(map,m,n));
        }
    }

