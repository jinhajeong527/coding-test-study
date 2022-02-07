package com.jjh.study.stage.one;

import java.util.ArrayList;
import java.util.Collections;

public class SecretMap {

	public static StringBuilder getBinary(int arrVal, int length){

			StringBuilder sb = new StringBuilder();
			int one = arrVal;

			while(one/2!=1) {//몫이 1이 되기 전까지.
				if(one%2==0) {
					sb.insert(0,"0");
				}else { //2로 나눈 나머지가 1일 경우
					sb.insert(0,"1");
				}
				one = one/2;
			}
			//몫 1이면 빠져나왔을 것이다.
			sb.insert(0, "1"+one%2);

			if(sb.length() < length) {
				sb.insert(0, String.join("", Collections.nCopies(length-sb.length(), "0")));
			}
			return sb;
	}



	public String[] solution(int n, int[] arr1, int[] arr2) {

			String[] answer = new String[n];

			for(int i=0; i<arr1.length; i++) {
			StringBuilder sb1 = getBinary(arr1[i], n);
			StringBuilder sb2 = getBinary(arr2[i], n);
			StringBuilder sb3 = new StringBuilder(n);

			for(int j=0; j<sb1.length(); j++) {
				if(sb1.charAt(j)=='1'||sb2.charAt(j)=='1') {
					sb3.append("#");
				}else if(sb1.charAt(j)=='0'&& sb2.charAt(j)=='0') {
					sb3.append(" ");
				}
			}
			answer[i] =(sb3.toString());

		}
		return answer;
    }
	

}
