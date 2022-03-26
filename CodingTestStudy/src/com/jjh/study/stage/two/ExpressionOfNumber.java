package com.jjh.study.stage.two;

//숫자의 표현
public class ExpressionOfNumber {
	public static void main(String[] args) {
		ExpressionOfNumber en = new ExpressionOfNumber();
		en.solution(15);
	}
	public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
        	int sum = 0;
        	int index = i;
        	while(true) {
        		sum += index;
        		index++;
        		if(sum == n) {
        			answer++;
        			break;
        		}else if( sum > n) {
        			break;
        		}
        	}
        }
        
        return answer;
    }

}
