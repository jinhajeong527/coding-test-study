package com.jjh.study.stage.two;


//이진 변환 반복하기
public class RepeatingBinaryTranslation {
	public static void main(String[] args) {
		RepeatingBinaryTranslation rb = new RepeatingBinaryTranslation();
		rb.solution("110010101001");
	}
	public int[] solution(String s) {
		String str = s;
		int count = 0;//0 발견할 때 마다 1씩 추가 된다.
		int changeCount = 0;//이진 변환 할 때 마다 1씩 추가 된다.
		while(!"1".equals(str)) {
			
			StringBuilder sb = new StringBuilder(str);
			StringBuilder sb2 = new StringBuilder();
			
			for(int i=0; i<sb.length(); i++) {
				if(sb.charAt(i) == '0') {
					count++;
				}else {
					sb2.append("1");
				}
			}
			int length = sb2.length();
			str = Integer.toBinaryString(length);//이진수로 바꿔준다.
			changeCount++;
		}
        int[] answer = new int[] {changeCount, count};
        return answer;
    }
	
}
