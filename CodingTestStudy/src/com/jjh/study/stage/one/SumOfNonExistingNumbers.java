package com.jjh.study.stage.one;


//없는 숫자 더하기
public class SumOfNonExistingNumbers {
	public int solution(int[] numbers) {
        
        boolean[] hasThisNumber = new boolean[10];
        int answer = 0;
        for(int i=0; i < numbers.length; i++){
        	hasThisNumber[numbers[i]] = true;
        }
        for(int i=0; i<hasThisNumber.length; i++) {
        	if(hasThisNumber[i]==false) {
        		answer += i;
        	}
        }
        return answer;
    }

}
