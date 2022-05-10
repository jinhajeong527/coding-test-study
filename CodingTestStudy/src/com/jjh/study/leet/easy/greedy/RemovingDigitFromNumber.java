package com.jjh.study.leet.easy.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemovingDigitFromNumber {
	
	public String removeDigit(String number, char digit) {
		
		StringBuilder sb = new StringBuilder(number);
		List<String> stringWithoutdigit = new ArrayList<>();
		
		for(int i = 0; i < number.length(); i++) {
			if(sb.charAt(i) == digit) {
				sb.deleteCharAt(i);
				stringWithoutdigit.add(sb.toString());
				/*
				String의 문자길이 조건으로 인해 int 형으로 받을 수 없음.
				int deletedValue = Integer.parseInt(sb.toString());
				max = max > deletedValue ? max : deletedValue;
				 */
				sb = new StringBuilder(number);
			}
		}
		Collections.sort(stringWithoutdigit);
        return stringWithoutdigit.get(stringWithoutdigit.size()-1);
    }

}
