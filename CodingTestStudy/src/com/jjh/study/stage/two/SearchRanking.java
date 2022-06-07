package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//프로그래머스 2단계: 순위 검색
public class SearchRanking {
	
	public static void main(String[] args) {
		SearchRanking sr = new SearchRanking();
		sr.solution(new String[] {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, 
				new String[] {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
	}
	
	public int[] solution(String[] info, String[] query) {
		
		List<Map<String,String>> conditionList = new ArrayList<>();
		
		for(int i = 0; i < info.length; i++) {
			String[] candidateInfos = info[i].split(" ");
			Map<String, String> candidate = new HashMap<String, String>();
			candidate.put("언어", candidateInfos[0]);
			candidate.put("직군", candidateInfos[1]);
			candidate.put("경력", candidateInfos[2]);
			candidate.put("소울푸드", candidateInfos[3]);
			candidate.put("점수", candidateInfos[4]);
			conditionList.add(candidate);
		}
		
		int[] answer = new int[query.length];
		
		List<Map<String,String>> requirementList = new ArrayList<>();
		
		for(int i = 0; i < query.length; i++) {
			Map<String, String> requirement = new HashMap<String, String>();
			String[] requiredConditions = query[i].split(" and ");
			String[] soulFoodAndScore = requiredConditions[3].split(" ");
			requirement.put("언어", requiredConditions[0]);
			requirement.put("직군", requiredConditions[1]);
			requirement.put("경력", requiredConditions[2]);
			requirement.put("소울푸드", soulFoodAndScore[0]);
			requirement.put("점수", soulFoodAndScore[1]);
			requirementList.add(requirement);
		}
		
		for(int i = 0; i < requirementList.size(); i++) {
			int totalCount = 0;
			Map<String, String> map = new HashMap<String, String>();
			map = requirementList.get(i);
			for(int j = 0; j < conditionList.size(); j++) {
				int count = 0;
				if((map.get("언어").equals(conditionList.get(j).get("언어")) || map.get("언어").equals("-"))) count++;
				else continue;
				if((map.get("직군").equals(conditionList.get(j).get("직군")) || map.get("직군").equals("-"))) count++;
				else continue;
				if((map.get("경력").equals(conditionList.get(j).get("경력")) || map.get("경력").equals("-"))) count++;
				else continue;
				if((map.get("소울푸드").equals(conditionList.get(j).get("소울푸드")) || map.get("소울푸드").equals("-"))) count++;
				else continue;
				if((Integer.parseInt(map.get("점수")) <= Integer.parseInt(conditionList.get(j).get("점수")))) count++;
				else continue;
				totalCount++;
			}
			answer[i]  = totalCount;
		}
        return answer;
    }
}
