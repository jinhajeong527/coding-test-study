package com.jjh.study.stage.two;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tuple {
	public static void main(String[] args) {
		Tuple tp = new Tuple();
		tp.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}
	public int[] solution(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder(s);
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		s = sb.toString();
		String[] strArr = s.split("},");
		
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = strArr[i].replaceAll("[{]", "");
			strArr[i] = strArr[i].replaceAll("[}]", "");
			String[] str = strArr[i].split(",");
			
			for(int j=0; j<str.length; j++) {
				if(!map.containsKey(str[j])) {
					map.put(str[j], 1);
				}else {
					map.replace(str[j], map.get(str[j])+1);
				}
			}
		}
		// Collections.sort()를 사용하기 위해서 List 형태로 Map을 가져와야 한다
		// Map.entrySet()을 이용하여 아래와 같이 Map의 Entry Set을 List 형태로 저장
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			//내림차순 정렬
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		List<Integer> list = new LinkedList<Integer>();
		for(Map.Entry<String, Integer> entry : entryList){
			list.add(Integer.parseInt(entry.getKey()));
		}
		
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }

}
