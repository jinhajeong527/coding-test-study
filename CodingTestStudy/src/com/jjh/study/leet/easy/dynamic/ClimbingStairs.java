package com.jjh.study.leet.easy.dynamic;

public class ClimbingStairs {

    // ==> 분할정복 방식으로 풀경우 타임 초과 발생
    // ==> 21/45 테스트 케이스 통과
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        cs.climbStairs(2);
    }
    int steps = 0;
    public int climbStairs(int n) {
        getHowManyWaysToGetToTheTop(n);
        return steps;
    }

    public void getHowManyWaysToGetToTheTop(int n) {
        if(n == 0) {
            steps++;
        }
        if(n-1 >= 0) getHowManyWaysToGetToTheTop(n-1);
        if(n-2 >= 0) getHowManyWaysToGetToTheTop(n-2);
    }
}
