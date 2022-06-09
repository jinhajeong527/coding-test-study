package com.jjh.study.stage.two;

import java.util.Stack;
// 카카오 프렌즈 2020 KAKAO BLIND RECRUITMENT 괄호변환
public class ParenthesisConversion {
	public static void main(String[] args) {
		ParenthesisConversion pc = new ParenthesisConversion();
//		String answer = pc.solution("()))((()");
		String answer = pc.solution(")(");
		System.out.println(answer);
	}
	public String solution(String p) {
        String answer = "";
        boolean isRight = isRightParenthesis(p);
        // 이미 올바른 괄호 문자열이라면 그대로 리턴해준다.
        if(isRight) return p;
        if(p.length()==2) return "()";
        int leftCount = 0;
    	int rightCount = 0;
        // 여기는 올바르지 않은 균형잡힌 문자열에 대한 처리가 시작된다.
        for(int i = 0; i < p.length(); i++) {
        	if(leftCount != 0 && rightCount != 0 && leftCount == rightCount) {
        		String u = p.substring(0,i);
        		String v = p.substring(i);
        		if(isRightParenthesis(u)) { // u가 올바른 문자열이라면 
        			v = makeThemRight(v);
        			return u + v;
        		} else { // u가 올바른 문자열이 아니라면
        			return "("+makeThemRight(v)+")"+doSomeModification(u);
        		}
        	}
        	if(p.charAt(i) == ')') {
        		rightCount++;
        	} else {
        		leftCount++;
        	}
        }
        return answer;
    }

	private String doSomeModification(String u) {
		StringBuilder sb = new StringBuilder(u);
		sb.deleteCharAt(0);
		sb.deleteCharAt(u.length() - 2);
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == ')') sb.setCharAt(i, '(');
			else sb.setCharAt(i, ')');
		}
		return sb.toString();
	}
	
	private String makeThemRight(String v) {
		if(isRightParenthesis(v)) return v;
		int leftCount = 0;
		int rightCount = 0;
		if(v.equals("")) return "";
		for(int i = 0; i < v.length(); i++) {
			
			if(leftCount != 0 && rightCount != 0 && leftCount == rightCount) {
				
        		String x = v.substring(0,i);
        		String y = v.substring(i);
        		if(isRightParenthesis(x)) {
        			y = makeThemRight(y);
        			return x + y;
        		} else {
        			x = doSomeModification(x);
        			return "(" + makeThemRight(y) + ")" + x;
        		}
        	
        	}
        	if(v.charAt(i) == ')') {
        		rightCount++;
        	} else {
        		leftCount++;
        	}
			
		}
		return null;
	}
	
	
	
	
	
	
	private boolean isRightParenthesis(String p) {
		
		Stack<Character> stack = new Stack<>();
		//시작이 닫힘 괄호면 올바른 괄호 문자열이 아니다.
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
