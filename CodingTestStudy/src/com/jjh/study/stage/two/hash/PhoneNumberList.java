package com.jjh.study.stage.two.hash;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//전화번호 리스트
public class PhoneNumberList {
	
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);//오름차순 정렬
		
		Map<Integer, String> map = new HashMap<>();
		
		for(int i=0; i<phone_book.length;  i++) {
			map.put(i, phone_book[i]);
		}
		
		for(int i=0; i<phone_book.length; i++) {
			String phone = phone_book[i];
			for(int j=i+1; j<phone_book.length; j++) {
				if(map.get(j).startsWith(phone)) { //오름차순 해주었기 때문에 다음거만 비교해주면 된다. 
					answer = false;
					break;
				}else {
					break;
				}
			}
	
		}
        
        return answer;
    }

}
