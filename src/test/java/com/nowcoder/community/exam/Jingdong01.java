package com.nowcoder.community.exam;
import org.apache.catalina.webresources.StandardRoot;

import java.util.*;
public class Jingdong01 {
    public static int dfs(int x,int y,String[][] arr,int flag,int[] x1,int[] y1){
        int m = arr.length;
        int n = arr[0].length;
        flag=0;
        if (arr[x][y].equals("E"))
            return 1;

        for(int i=0;i<4;i++){
            int xx=x+x1[i];
            int yy = y+y1[i];
            if(xx>=0&&xx<m&&yy>=0&&yy<n&&!arr[xx][yy].equals("#")){
                arr[x][y]="#";
                flag=dfs(xx,yy,arr,flag,x1,y1);
                if(flag==1)
                    return 1;
                else
                {
                    continue;
                }
            }
        }
        return 0;


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int num = 0;
        while(num<number){
            int n = in.nextInt();
            int m = in.nextInt();
            String[][] arr = new String[n][m];
            int x = 0;
            int y=0;
            in.nextLine();
            for(int i = 0;i<n;i++){
              String temp= in.nextLine();
              for (int j=0;j<m;j++) {
                  String cur = String.valueOf(temp.charAt(j));
                  arr[i][j]=cur;
                  if (cur.equals("S")){
                       x = i;
                       y = j;
                  }
              }
            }
           int flag=0;
            int[] x1=new int[]{1,-1,0,0};
            int[] y1 = new int[]{0,0,-1,1};
            if (dfs(x,y,arr,flag,x1,y1)==1)
                System.out.println("YES");
            else
                System.out.println("NO");
            num++;
        }
    }
}
