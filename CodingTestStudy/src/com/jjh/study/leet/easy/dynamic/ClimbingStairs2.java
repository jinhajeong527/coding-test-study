package com.jjh.study.leet.easy.dynamic;

//동적 프로그래밍 방법
public class ClimbingStairs2 {

    public int climbStairs(int n) {

        if(n <= 1) return 1;
        int[] dp = new int[n+1]; //index 1부터 사용할 것이기 때문에 배열 크기 n+1로 선언해준다.
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
           dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
