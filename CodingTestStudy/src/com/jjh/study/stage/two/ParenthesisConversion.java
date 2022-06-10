package com.jjh.study.stage.two;

import java.util.Stack;
// 카카오 프렌즈 2020 KAKAO BLIND RECRUITMENT 괄호변환
public class ParenthesisConversion {
	public static void main(String[] args) {
		ParenthesisConversion pc = new ParenthesisConversion();
		//String answer = pc.solution("()))((()");
		String answer = pc.solution(")(");
		System.out.println(answer);
	}
	public String solution(String p) {
        String answer = "";
        // 길이가 0이라면 "" 리턴해준다.
        if(p.length() == 0) return "";
        
        // 이미 올바른 괄호 문자열인지 체크하고 맞다면 그대로 리턴해준다.
        if(isRightParenthesis(p)) return p;
        
        // '(' 개수 세는 leftCount, ')' 개수 세는 rightCount
        int leftCount = 0, rightCount = 0;
        
        // 여기는 올바르지 않은 균형잡힌 문자열에 대한 처리가 시작된다.
        for(int i = 0; i < p.length(); i++) {
        	
        	if(p.charAt(i) == ')') rightCount++;
        	else leftCount++;
        	
        	if(leftCount != 0 && leftCount == rightCount) {
        		
        		String u = p.substring(0, i+1);
        		String v = "";
        		if(i != p.length()-1) v = p.substring(i+1);
        		
        		if(isRightParenthesis(u)) { // u가 올바른 문자열이라면 
        			v = makeThemRight(v);
        			return u + v;
        		} else { // u가 올바른 문자열이 아니라면 v에 대해 단계 1부터 진행해준다.
        			return "("+makeThemRight(v)+")"+doSomeModification(u);
        		}
        	}
        }
        return answer;
    }
	// 문자열을 규칙에 따라 분리한 후에도 앞 문자열이 여전히 올바른 괄호 문자열이 아닐 때 호출되는 메서드
	// 문자열 u를 변형해주어야 한다.
	private String doSomeModification(String u) {

		StringBuilder sb = new StringBuilder(u);
		// 맨 앞 char를 지운다.
		sb.deleteCharAt(0);
		// 맨 뒤 char를 지운다. 이미 앞에서 하나 지워주었으니 length - 1이 아니라 length - 2가 된다.
		sb.deleteCharAt(u.length() - 2);
		
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == ')') sb.setCharAt(i, '(');
			else sb.setCharAt(i, ')');
		}
		return sb.toString();
	}
	
	private String makeThemRight(String v) {
		if(v.length() == 0) return "";
		if(isRightParenthesis(v)) return v;
		int leftCount = 0;
		int rightCount = 0;
	
		for(int i = 0; i < v.length(); i++) {
			if(v.charAt(i) == ')') {
        		rightCount++;
        	} else {
        		leftCount++;
        	}
			if(leftCount != 0 && leftCount == rightCount) {
				
        		String x = v.substring(0, i+1);
        		String y = "";
        		if(i != v.length()-1) y = v.substring(i+1);
        		
        		if(isRightParenthesis(x)) {
        			y = makeThemRight(y);
        			return x + y;
        		} else {
        			return "(" + makeThemRight(y) + ")" + doSomeModification(x);
        		}
        	}
		}
		return null;
	}
	
	// 올바른 괄호 문자열인지 체크하는 메서드
	private boolean isRightParenthesis(String p) {
		
		Stack<Character> stack = new Stack<>();
		// 시작이 닫힘 괄호면 올바른 괄호 문자열이 아니다.
		if(p.charAt(0) == ')') return false;
		
		for(int i = 0; i < p.length(); i++) {
			// 열림 소괄호만 스택에 넣어준다.
			if(p.charAt(i) == '(') stack.push(p.charAt(i));
			else { // ')' 닫힘 괄호이면
				if(stack.isEmpty()) return false;
				else stack.pop();
			}
		}
		
		return true;
	}

}
