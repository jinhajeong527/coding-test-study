package com.jjh.study.stage.two;

//124나라의 숫자
public class NumberOf124Nation {
	
	public String solution(int n) {
		String answer = "";
		String[] numbers = { "4", "1", "2" };
		int r =0;
		
		while(n > 0) {
			r = n % 3;
			n /= 3;
			if(r==0) n--;
			answer = numbers[r]+ answer;
		}
        return answer;
    }
}
