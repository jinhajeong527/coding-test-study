package com.jjh.study.stage.one;

public class SquareRootVerification {
	public long solution(long n) {
		long answer = 0;
		double answerDouble = 0;
		answerDouble = Math.sqrt(n);
		if(answerDouble%1 != 0) {
			answer = -1;
			return answer;
			
		}else {
			answer = (long)Math.pow(answerDouble+1, 2);
			return answer;
		}
    }
}
