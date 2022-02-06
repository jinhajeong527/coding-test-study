package com.jjh.study.stage.one;

public class SquareRootVerification {
	public long solution(long n) {
		long answer = 0;
		double answerDouble = 0;
		//제곱근의 값 구하는 메서드 사용
		answerDouble = Math.sqrt(n);
		if(answerDouble%1 != 0) {
			answer = -1;
			return answer;
			
		}else { // 정수이면 %1==0일 것. 제곱근 공식 작성한다.
			answer = (long)Math.pow(answerDouble+1, 2);
			return answer;
		}
    }
}
