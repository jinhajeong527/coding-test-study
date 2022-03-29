package com.jjh.study.stage.two;

//n진수 게임
public class NNotationGame {
	public static void main(String[] args) {
		NNotationGame nn = new NNotationGame();
		nn.solution(16, 16, 2, 1);
	}
	
	public String solution(int n, int t, int m, int p) {
		
		StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while(sb.length() < t * m) {
        	sb.append(Integer.toString(number++, n));
        }
        
        for(int i = p - 1 ; i <  t*m ; i = i+ m) {
        	answer.append(sb.charAt(i));
        }
        return answer.toString().toLowerCase();
    }

}
