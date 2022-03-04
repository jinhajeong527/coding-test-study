package com.jjh.study.stage.two.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Disguise {

	public int solution(String[][] clothes) {

		int answer = 1;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1],1) + 1);
		}
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			answer *= map.get(it.next());
		}

		return answer-1;
	}

}
