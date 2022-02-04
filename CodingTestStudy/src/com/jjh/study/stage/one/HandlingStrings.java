package com.jjh.study.stage.one;

public class HandlingStrings {
	public boolean solution(String s) {
		boolean answer = false;
		int length = s.length();
		if(length==4||length==6) {
			try{
				Integer.parseInt(s);
			}catch(Exception exception) {
				answer = false;
				return answer;
			}
			answer =true;
		}
        return answer;
    }

}
