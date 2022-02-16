package com.jjh.study.stage.one;

import java.util.ArrayList;
import java.util.List;

//소수만들기: 중복값도 가능하다.
public class MakingPrimeNumber {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(isPrimeNumber(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
        //메서드로 만든다.
        public boolean isPrimeNumber(int num){
            for(int m = 2; m < num; m++) {
                if (num % m == 0) return false;
            }
            return true;
        }

}
