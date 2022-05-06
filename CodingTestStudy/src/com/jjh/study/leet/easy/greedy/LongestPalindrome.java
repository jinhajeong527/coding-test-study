package com.jjh.study.leet.easy.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		lp.longestPalindrome("ccd");
	}
	public int longestPalindrome(String s) {
		int answer = 0;
		int oddMax = 0;
		if(s.length() == 1) return 1;
		char[] strChar = s.toCharArray();
		Arrays.sort(strChar);
		char prev = strChar[0];
		Map<Character, Integer> map = new HashMap<>();
		map.put(prev, 1);
		
		for(int i = 1; i < strChar.length ; i++) {
			// prev와 같을 시에 map에서 해당 키 카운트 값 증가시켜 준다.
			if(prev == strChar[i]) {
				
				map.put(strChar[i], map.get(prev) + 1);
				
				if(i == strChar.length - 1) { //마지막 인덱스였을 경우에
					int count = map.get(prev);
					//짝수면 answer에 더해준다
					if(count % 2 == 0) answer += count;
					else {
						if(oddMax > count) {
							answer += count - 1;
						} else {
							if(oddMax>1) answer += oddMax -1;
							oddMax = count;
						}
					}
				}
					
			} else { // prev와 현재 char 같지 않을 때 전의 char 숫자 세서 answer에 추가시킬지 말지 결정한다.
				int count = map.get(prev);
				if(count % 2 == 0) answer += count;
				else {
					if(oddMax > count) {
						answer += count - 1;
					} else {
						if(oddMax > 1) answer += oddMax -1;
						oddMax = count;
					}
				}
				map.put(strChar[i], 1);
				
				//prev와 같지 않으면서 마지막인 경우? // ex) ccd
				if(i == strChar.length - 1) {
					oddMax = (oddMax > 1) ? oddMax : 1;
				}
			}
			prev = strChar[i];
		}
		answer += oddMax;
		return answer;    
    }

}