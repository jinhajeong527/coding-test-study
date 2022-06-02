package com.jjh.study.leet.easy.greedy;

// 리트코드: 680. Valid Palindrome II
public class ValidPalindromeII {
	
	public boolean validPalindrome(String s) {
		// 맨 앞 char와 맨 끝의 char를 처음 비교한다.
		int i = 0;
		int j = s.length() - 1;
		// 길이가 1인 경우라면 바로 true이므로 while문을 거칠 필요도 없다.
		while(i < j) {
			// 같지 않으면, j인덱스 하나 뺀 것과 i인덱스 비교, i인덱스 하나 더한것과 j인덱스 비교한다.
			if(s.charAt(i) != s.charAt(j)) return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
			i++;
			j--;
		}
		return true;   
    }

	private boolean isPalindrome(String s, int i, int j) {
		while(i < j) {
			// 이번에도 같지 않다면, false 리턴되어야 한다. 최대 한번까지만 삭제할 수 있기 때문이다.
			if(s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

}
