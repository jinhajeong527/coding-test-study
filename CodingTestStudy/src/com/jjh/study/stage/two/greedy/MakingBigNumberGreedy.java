package com.jjh.study.stage.two.greedy;

import java.util.Stack;

//큰 수 만들기
public class MakingBigNumberGreedy {
	public static void main(String[] args) {
		MakingBigNumberGreedy mbng = new MakingBigNumberGreedy();
		mbng.solution("1924", 2);
	}
	
	public String solution(String number, int k) {
		
		char[] result = new char[number.length()-k];
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < number.length(); i++) {
			char num = number.charAt(i);
			while(!stack.isEmpty() && stack.peek() < num && k-- > 0) { // 1) stack 비어있지 않고, 2) 해당 인덱스의 char가 스택에서 pop한 값보다 크고, 3) k--가 0보다 클 때
				stack.pop();
			}
			stack.push(num);
		}
		
		for(int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		
		return new String(result);
    }

}
