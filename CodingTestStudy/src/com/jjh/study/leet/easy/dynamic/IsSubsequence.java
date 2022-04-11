package com.jjh.study.leet.easy.dynamic;

public class IsSubsequence {
	
	public static void main(String[] args) {
		
		IsSubsequence is = new IsSubsequence();
		is.isSubsequence("abc", "ahbgdc");
		
	}
	
	public boolean isSubsequence(String s, String t) {
		
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int index = 0;
		int count = 0;
		
		for(int i = 0; i < sChars.length; i++) {
			
			for(int j = index; j < tChars.length; j++) {
				
				if(sChars[i] == tChars[j]) { //같으면, tChras j 인덱스 +1 부터 다음에 탐색하면 된다.
					index = j+1;
					count++;
					//아직 i 다 안돌았는데 index 길이가 tChras보다 같거나 커지면 더이상 탐색할 수 없으므로 false를 리턴한다.
					if(index >= tChars.length && i < sChars.length-1) return false;
					break;
				}
			}
		}
		//sChars 길이와 count가 같으면 전부 일치하는 것 찾았다는 뜻이므로 true를 리턴해준다.
		if(count == sChars.length) return true;
		else return false;
    }

}
