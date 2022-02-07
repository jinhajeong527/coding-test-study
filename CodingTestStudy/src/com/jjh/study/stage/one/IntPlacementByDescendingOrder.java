package com.jjh.study.stage.one;

import java.util.ArrayList;
import java.util.Comparator;

public class IntPlacementByDescendingOrder {
	public long solution(long n) {
		long answer = 0;
		String longStr = Long.toString(n);
		ArrayList<Long> list = new ArrayList<Long>();
		
		for(int i=0; i<longStr.length(); i++) {
			list.add(Long.parseLong(Character.toString(longStr.charAt(i))));
		}
		
		list.sort(Comparator.reverseOrder());
		String answerStr = "";
		for(int i =0;i<list.size();i++) {
			answerStr += list.get(i);
		}
		
		answer = Long.parseLong(answerStr);
       
        return answer;
    }
}
