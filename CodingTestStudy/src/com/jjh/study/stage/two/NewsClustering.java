package com.jjh.study.stage.two;

import java.util.HashMap;
import java.util.Map;

public class NewsClustering {
	public static void main(String[] args) {
		NewsClustering nc = new NewsClustering(); 
		//nc.solution("FRANCE", "french");
		// E=M*C^2	e=m*c^2
		// 두 집합이 모두 공집합이 되는 경우 
		nc.solution("E=M*C^2", "e=m*c^2");
	}
	public int solution(String str1, String str2) {
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		
		map1 = makeMulitiset(str1);
		map2 = makeMulitiset(str2);
		// == null이 아니라 isEmpty로 체크해야 한다.
		if(map1.isEmpty() && map2.isEmpty()) return 65536;
		
		// 교집합 카운트
		int interCount = 0;
		// 합집합 카운트
		int sumCount = 0;
		
		for(String key : map1.keySet()) {
			if(map2.containsKey(key)) { // 키를 포함하고 있다면 교집합의 대상이 된다. 개수는 비교가 필요하다.
				interCount += map1.get(key) >= map2.get(key) ? map2.get(key) : map1.get(key);
				// 합집합은 해당 키 더 많이 갖고 있는 경우를 기준으로 추가되어야 한다.
				sumCount += map1.get(key) >= map2.get(key) ? map1.get(key) : map2.get(key);
				map2.remove(key); // 해당 키 map2에서 삭제해준다.
			} else { // map2에 없는 경우 합집합에 단순 개수 추가
				sumCount += map1.get(key);
			}
		}
		// 위에서 교집합 키는 모두 카운트 더한후 삭제해주었기 때문에 map2에는 합집합 카운트에 해당하는 키만 남아있는 상태이다.
		for(String key : map2.keySet()) {
			sumCount += map2.get(key);
		}
		double answerDouble = (double)interCount/sumCount * 65536;
        int answer = (int)answerDouble;
        return answer;
    }
	// 문자열 중복집합 만들기 메서드
	private Map<String, Integer> makeMulitiset(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < str.length() - 1; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(i));
			sb.append(str.charAt(i + 1));
			if(!isPassString(sb.toString())) {
				map.put(sb.toString().toUpperCase(), map.getOrDefault(sb.toString().toUpperCase(), 0) + 1);
			}
		}
		return map;
	}
	// 문자열에 영문자만 있는지 확인하는 메서드
	private boolean isPassString(String str) {
		String regex = "[a-zA-Z]+";
		if(str.matches(regex)) return false;
		return true;
	}
}
