package com.jjh.study.leet.easy.dfs;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		vp.isValid("{(})");
		vp.isValid("((");
	}
	public boolean isValid(String s) {
	 Stack<Character> stack = new Stack<>();
	 if(s.length()%2==1) return false; //짝이 안맞다는 뜻이므로 false return
	 if(s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']') return false; //처음 시작이 closing이 되므로 false return
	 
	 for(int i=0; i<s.length(); i++) {
		 if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') {
			 stack.push(s.charAt(i));
		 }
		 else if(s.charAt(i)==')') {
			 //스택 비어있으면 false
			 if(stack.isEmpty()) return false;
			 else if(stack.peek() !='(') return false;
			 else stack.pop();
		 }
		 else if(s.charAt(i)=='}') {
			 if(stack.isEmpty()) return false;
			 else if(stack.peek() !='{') return false;
			 else stack.pop();
		 }
		 else if(s.charAt(i)==']') {
			 if(stack.isEmpty()) return false;
			 else if(stack.peek() !='[') return false;
			 else stack.pop();
		 }
		 
	}
	 //이 때 아직 비어있지 않다면 '(('같은 경우일 수 있기에 false return 
	 if(!stack.isEmpty()) return false;
	 else return true;   
    }

}
