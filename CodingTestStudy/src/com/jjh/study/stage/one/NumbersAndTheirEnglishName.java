package com.jjh.study.stage.one;


//숫자 문자열과 영단어
public class NumbersAndTheirEnglishName {
	public int solution(String s) {
		String[] ones = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
		String[] twos = new String[]{"0","1","2","3","4","5","6","7","8","9"};
		for(int i=0; i<ones.length; i++) {
			s = s.replace(ones[i], twos[i]);
		}
		
		int answer =Integer.parseInt(s);
        return answer;
    }

}
