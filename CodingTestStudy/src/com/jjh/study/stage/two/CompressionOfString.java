package com.jjh.study.stage.two;

public class CompressionOfString {
	public static void main(String[] args) {
		CompressionOfString cos = new CompressionOfString();
		cos.solution("aabbaccc"); // 2a2ba3c
	}
	
	public int solution(String s) {
		
		// 하나도 압축되지 않았을 때는 문자열의 길이만큼이 정답이 될 것이다. (ex) abcdefg 같은 경우
		int answer = s.length();
		
		// 압축 가능한 문자열의 길이는 1 부터 (문자열의 길이 / 2) 까지이다.
		for(int i = 1; i <= s.length()/2; i++) {
			String curr = "";
			// 압축 된 문자 기록 변수 encrypted
			String encrypted = "";
			// 같은 문자 있을 시에 count 해주는 int 변수
			int count = 1;
			// 인덱스 0부터 i index 전까지 자른다. 즉 길이 i 만큼 자른다.
			// 이전 문자 기록 변수 prev
			String prev = s.substring(0, i);
			
			for(int j = i; j <= s.length(); j += i) { // ** j <= s.length() **
				
				if(i + j >= s.length()) {
					curr = s.substring(j, s.length());	
				} else {
					curr = s.substring(j, j+i);
				}
				
				if(curr.equals(prev)) { // 같은 경우 압축이 가능하다. count 올려준다.
					count++;
				} else if(count == 1) { // 다르면서 count도 1
					encrypted += prev;
					prev = curr;
				} else { //다르면서 count도 1이 아닌 경우
					encrypted += count + prev;
					prev = curr;
					count = 1;
				}
			}
			if(i != prev.length()) encrypted += prev; 
			answer = Math.min(answer, encrypted.length());
		}
        return answer;
    }

}
