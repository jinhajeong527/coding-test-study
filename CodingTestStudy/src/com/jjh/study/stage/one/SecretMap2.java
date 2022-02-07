package com.jjh.study.stage.one;


import java.util.Collections;

public class SecretMap2 {

	public String[] solution(int n, int[] arr1, int[] arr2) {

			String[] answer = new String[n];

			for(int i=0; i<arr1.length; i++) {

			String str1 = Integer.toBinaryString(arr1[i]);
			String str2 = Integer.toBinaryString(arr2[i]);
			StringBuilder sb = new StringBuilder(n);
			if(str1.length()<n) str1 = String.join("", Collections.nCopies(n-str1.length(), "0")) +str1;
			if(str2.length()<n) str2 = String.join("", Collections.nCopies(n-str2.length(), "0")) +str2;

			for(int j=0; j < n; j++) {
				if(str1.charAt(j)=='1'||str2.charAt(j)=='1') {
					sb.append("#");
				}else if(str1.charAt(j)=='0'&& str2.charAt(j)=='0') {
					sb.append(" ");
				}
			}
			answer[i] =(sb.toString());

		}
		return answer;
    }
	

}
