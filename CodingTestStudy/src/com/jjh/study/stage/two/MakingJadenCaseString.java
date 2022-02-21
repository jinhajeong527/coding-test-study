package com.jjh.study.stage.two;

//Jaden Case 문자열 만들기
public class MakingJadenCaseString {
	
	public String solution(String s) {
		char[] chars = s.toCharArray();
		
		for(int i=0; i<chars.length; i++) {
			
		//숫자로 시작하지 않으면 첫문자를 대문자로 바꿔준다.
		if(!Character.isDigit(chars[0]) && i==0) 
			chars[i] = Character.toUpperCase(chars[0]);
		//공백이면 무시하고 진행한다.	
		else if(chars[i]==' ') continue;
		//전에가 공백이고 지금이 문자열이면 대문자로 바꿔준다.
		else if(i>0 && chars[i-1]== ' ' && Character.isLetter(chars[i])) 
			chars[i] = Character.toUpperCase(chars[i]);
		//그 외에는 소문자로 바꿔준다.
		else if(i>0 && Character.isLetterOrDigit(chars[i-1]) && Character.isLetter(chars[i])) 
			chars[i] = Character.toLowerCase(chars[i]);
		
		}
		
		//차배열을 스트링으로 바꿔준다.
        String answer = String.valueOf(chars);
        return answer;
		
	}

}
