package com.jjh.study.leet.easy.greedy;

public class LargestOddNumberInString {
	public String largestOddNumber(String num) {
		char[] numChar = num.toCharArray();
		for(int i = num.length()-1; i >= 0; i--) {
			if(Integer.parseInt(numChar[i]+"") % 2 == 1) return num.substring(0, i+1);
			else continue;
		}
		return "";
    }
}
