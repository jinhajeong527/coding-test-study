package com.jjh.study.stage.one;

public class GreatestCommonDivisorAndLeastCommonMultiple {
    public int[] solution(int n, int m) {
        int biggerNum =0;
        int smallerNum =0;

        if(n>m){
            biggerNum=n;
            smallerNum=m;
        }else{
            biggerNum=m;
            smallerNum=n;
        }
        while(biggerNum%smallerNum!=0) {
            int rest = biggerNum % smallerNum;
            biggerNum = smallerNum;
            smallerNum = rest;
        }
        int[] answer = {smallerNum, smallerNum*(n/smallerNum)*(m/smallerNum)};

        return answer;
    }
}
