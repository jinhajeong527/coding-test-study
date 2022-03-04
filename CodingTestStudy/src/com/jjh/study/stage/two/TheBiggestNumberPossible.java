package com.jjh.study.stage.two;

import java.util.Arrays;

public class TheBiggestNumberPossible {
	public static void main(String[] args) {
		TheBiggestNumberPossible tp = new TheBiggestNumberPossible();
		tp.solution(new int[]{ 30, 314, 34, 5, 9});
	}
	public String solution(int[] numbers) {
		
		String[] intArr = new String[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			intArr[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(intArr);
		
//		for(int i=0; i<intArr.length; i++) {
//			System.out.println(intArr[i]);
//		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = intArr.length-1; i >= 0; i--) {
			if( i-1>=0 && intArr[i].length() > intArr[i-1].length()) {
				String str1 = intArr[i].substring(intArr[i].length()-1, intArr[i].length());
				String str2 = intArr[i-1].substring(0,1);
				if(Integer.valueOf(str1)<Integer.valueOf(str2)) {
					
					sb.append(intArr[i-1]);
					sb.append(intArr[i]);
					i--;
				}else {
					sb.append(intArr[i]);
					sb.append(intArr[i-1]);
					i--;
				}
			}else {
				sb.append(intArr[i]);
			}
		}
		String answer = sb.toString();
		//System.out.println(answer);
		return answer;
	}

}
