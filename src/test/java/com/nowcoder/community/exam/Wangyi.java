package com.nowcoder.community.exam;


import java.util.Scanner;

public class Wangyi {

    public static class Game{
        int cheng;
        int day;
        public Game(int cheng,int day){
            this.cheng=cheng;
            this.day=day;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        Game[] games = new Game[n];
        int index=0;

        while (sc.hasNextInt()) {

            int cheng = sc.nextInt();
            int day = sc.nextInt();
            games[index]=new Game(cheng,day);
            index++;
        }

        int[][] dp= new int[n][x+1];

        for (int i=0;i<n;i++) {
            int curDay = games[i].day;
            if (i>0){
                if (curDay*2<=x){
                    dp[i][2*curDay]=dp[i-1][curDay]+games[i].cheng;

                }
                dp[i][curDay]=Math.max(dp[i-1][curDay],games[i].cheng);
            }
            for (int j = 1; j <= x; j++) {
                if (i == 0) {
                    dp[0][games[0].day] = games[0].cheng;
                    break;
                }
                if (j!=curDay) {
                    dp[i][j] =Math.max(dp[i][j],dp[i - 1][j]);
                }

                if (j+curDay<=4){
                    dp[i][j+curDay]=dp[i][j]+dp[i][curDay];
                }


            }

        }
        int res=0;
        for(int q=1;q<=x;q++){
            res=Math.max(res,dp[n-1][q]);
        }
        System.out.println(res);

    }


}

