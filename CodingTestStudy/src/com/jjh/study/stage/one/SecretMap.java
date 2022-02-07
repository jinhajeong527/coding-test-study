package com.jjh.study.stage.one;

import java.util.ArrayList;
import java.util.Collections;

public class SecretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		for(int i=0; i<arr1.length; i++) {
			StringBuilder sb = new StringBuilder();
			int one = arr1[i];
			
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
			
			if(sb.length() < n) {
				sb.insert(0, String.join("", Collections.nCopies(n-sb.length(), "0")));
			}
			list1.add(sb.toString());
			
		}
		for(int i=0; i<arr2.length; i++) {
			StringBuilder sb = new StringBuilder();
			int one = arr2[i];
			
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
			
			if(sb.length() < n) {
				sb.insert(0, String.join("", Collections.nCopies(n-sb.length(), "0")));
			}
			list2.add(sb.toString());
		}
		ArrayList<String> list3 = new ArrayList<String>();
		for(int i=0; i<list1.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<list1.get(i).length(); j++) {
				
				if(list1.get(i).charAt(j)=='1'||list2.get(i).charAt(j)=='1') {
					sb.append("#");
				}else if(list1.get(i).charAt(j)=='0'&& list2.get(i).charAt(j)=='0') {
					sb.append(" ");
				}
			}
			list3.add(sb.toString());
		}
		
		String[] answer = new String[list3.size()];
		answer = list3.toArray(answer);
        
        return answer;
    }
	

}
