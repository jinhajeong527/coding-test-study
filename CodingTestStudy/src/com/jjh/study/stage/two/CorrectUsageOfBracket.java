package com.jjh.study.stage.two;

//올바른 괄호
public class CorrectUsageOfBracket {
	boolean solution(String s) {
        boolean answer = false;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int left = 0;
        int right = 0;
        //처음부터 ')'로 시작하거나, 전체 차배열의 길이가 홀수이면 false를 return 한다.
        if(chars[0]==')' || length%2==1) return answer;
        else {
        	for(int i=0; i<length; i++) {
        		//오른쪽 괄호 수가 왼쪽보다 많아지면 false return 한다.
        		if(left  < right) return answer;
        		if(chars[i]=='(') left++;
        		if(chars[i]==')') right++;
        	}
        }
        if(left == right) answer = true;

        return answer;
    }
}
