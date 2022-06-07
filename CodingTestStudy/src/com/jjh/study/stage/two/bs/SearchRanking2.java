package com.jjh.study.stage.two.bs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


// 프로그래머스 2단계 : 순위 검색
public class SearchRanking2 {
	static HashMap<String, List<Integer>> map;
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<String, List<Integer>>();
		
		for(int i = 0; i < info.length; i++) {
			//예시 데이터: "java backend junior chicken 150"
			String[] infoSplits = info[i].split(" ");
			//각 지원자들의 조건으로 만들어질 수 있는 모든 경우의 수 맵을 만든다.
			makeSentence(infoSplits, "", 0);
		}
		
		// 각 키마다의 점수 리스트 오름차순으로 정렬
		for(String key: map.keySet())
			Collections.sort(map.get(key));
		
		for(int i = 0; i < query.length; i++) {
			query[i] = query[i].replace(" and ", "");
			String[] querySplit = query[i].split(" "); //자격 요건 및 점수 두개의 배열로 나뉨
			answer[i] = map.containsKey(querySplit[0]) ? binarySearch(querySplit[0], Integer.parseInt(querySplit[1])) : 0;
		}
        
        return answer;
    }
	
	private int binarySearch(String key, int score) {
		//해당 키의 조건 충족하는 지원자 점수 리스트 가져오기
		List<Integer> list = map.get(key);
		int start = 0, end = list.size() - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(list.get(mid) < score) start = mid + 1;
			else end = mid - 1;
		}
		return list.size() - start;
	}

	private static void makeSentence(String[] infoSplits, String infos, int count) {
		if(count == 4) { //즉 4개의 지원자 조건이 다 채워졌을 때 점수를 value로 넣어준다.
			// 해당 키로 만들어진 리스트가 없을 경우 생성해준다.
			if(!map.containsKey(infos)) {
				List<Integer> list = new ArrayList<Integer>();
				map.put(infos, list);
			}
			//해당 키 리스트에 코딩 테스트 획득 점수 추가해준다.
			map.get(infos).add(Integer.parseInt(infoSplits[4]));
			return;
		}
		makeSentence(infoSplits, infos + "-", count + 1);
		makeSentence(infoSplits, infos + infoSplits[count], count + 1);
	}
}
