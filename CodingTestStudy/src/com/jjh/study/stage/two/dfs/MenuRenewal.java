package com.jjh.study.stage.two.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//프로그래머스 2단계: 메뉴 리뉴얼
public class MenuRenewal {
	
	static HashMap<String,Integer> map;
	
	public static void main(String[] args) {
		MenuRenewal mr = new MenuRenewal();
		mr.solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2,3,4 });
	}
	
	public String[] solution(String[] orders, int[] course) {
		
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < orders.length; i++) {
        	//각 스트링 char 배열로 만들기
        	char[] order = orders[i].toCharArray();
        	//오름차순으로 정렬하기
        	Arrays.sort(order);
        	//오름차순으로 정렬할 것 다시 String 배열에 심어준다.
        	orders[i] = String.valueOf(order);
        }
        // 코스로 만들기를 희망하는 가지 수 당 최대 주문 건수 메뉴를 리스트에 추가할 것이다.
        for(int i = 0; i < course.length; i++) {
        	map = new HashMap<String, Integer>();
        	int max = Integer.MIN_VALUE;
        	
        	for(int j = 0; j < orders.length; j++) {
        		StringBuilder sb = new StringBuilder();
        		// 주문의 길이가 코스 길이보다 같거나 길어야지 조합을 만드는 의미가 있음.
        		if(course[i] <= orders[j].length()) 
        			combi(orders[j], sb, 0, 0, course[i]);
        	}
        	// 해당 코스 요리 가지수에 해당하는 모든 경우의 수 중 가장 많이 주문 된 조합의 수를 찾는다.
        	for(Entry<String, Integer> entry : map.entrySet())
        		max = Math.max(max, entry.getValue());
        	
        	for(Entry<String, Integer> entry : map.entrySet()) {
        		//최소 두 명 이상이 주문 했어야 하기에 max >= 2 조건 필요하다.
        		if(max >= 2 && entry.getValue() == max) {
        			list.add(entry.getKey());
        		}
        	}
        	
        }
        // 오름차순 정렬
        Collections.sort(list);
        // String 배열로 리턴해야 하므로 변환 작업 거쳐준다.
        String[] answer = new String[list.size()];
        return list.toArray(answer);
    }

	private void combi(String string, StringBuilder sb, int index, int count, int n) {
		if(count == n) {  
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}
		// **index부터 시작하여 조합을 구할 수 있다.
		for(int i = index; i < string.length(); i++) {
			sb.append(string.charAt(i));
			combi(string, sb, i+1, count+1, n);
			// 붙인거 다시 뗀다.
			sb.delete(count, count+1);
		}
	}

	

}
