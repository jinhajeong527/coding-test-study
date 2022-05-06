package com.jjh.study.leet.easy.greedy;

import java.util.HashSet;

public class LongestPalindrome2 {
	public static void main(String[] args) {
		LongestPalindrome2 lp = new LongestPalindrome2();
		lp.longestPalindrome("ccd");
	}
	public int longestPalindrome(String s) {
		int count = 0; 
		char[] chars = s.toCharArray();
		HashSet<Character> set = new HashSet<>();
		
		for(int i = 0; i < chars.length; i++) {
			if(set.contains(chars[i])) {
				count++;
				set.remove(chars[i]);
			} else {
				set.add(chars[i]);
			}
		}
		int answer = count * 2 + (!set.isEmpty() ? 1 : 0);
		return answer;
    }

}