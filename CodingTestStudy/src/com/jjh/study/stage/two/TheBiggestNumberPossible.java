package com.jjh.study.stage.two;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumberPossible {
	public static void main(String[] args) {
		TheBiggestNumberPossible tp = new TheBiggestNumberPossible();
		tp.solution(new int[]{ 1, 10, 100, 1000});
	}
	public String solution(int[] numbers) {
		
		String[] intArr = new String[numbers.length];

		for(int i = 0; i < numbers.length; i++) {
			intArr[i] = Integer.toString(numbers[i]);
		}
		
		//내림차순 정렬이다.
		Arrays.sort(intArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});

		if(intArr[0].equals("0")) return "0";

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < intArr.length; i++) {
			sb.append(intArr[i]);
		}

		return sb.toString();
	}

}
