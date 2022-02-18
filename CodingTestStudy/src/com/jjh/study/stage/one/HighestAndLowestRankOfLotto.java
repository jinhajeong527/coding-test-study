package com.jjh.study.stage.one;

import java.util.Arrays;

//로또의 최고순위와 최저순위
public class HighestAndLowestRankOfLotto {
	public int[] solution(int[] lottos, int[] win_nums) {
		int zeroCount = 0;
		int winCount = 0;
		int totalCount = lottos.length;
		//일치하는 당첨번호 빨리 찾으려고 sort 함.
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		//0으로 표시해준 로또 번호 몇개인지 세준다.
		for(int i=0; i < totalCount; i++) {
			if(lottos[i]==0) zeroCount++;
			else break;
		}
		//0 이후부터  당첨번호랑 일치하는 개수 센다.
		for(int i=zeroCount; i<totalCount; i++) {
			for(int j=0; j<totalCount; j++) {
				if(lottos[i] == win_nums[j]) {
					winCount++; break;
				}
			}
		}
		
		int maxCount = winCount + zeroCount;
		int minCount = winCount;
		int[] answer = new int[2];
		int[] rank = {6,5,4,3,2,1};
		for(int i=0; i < totalCount;  i++) {
			//전부 다 틀린경우 추가해주었다. 조건문을 전부 타게돼서 마지막의 i+1값인 6이 들어갈 것.
			if(rank[i]==maxCount || maxCount==0) answer[0] =i+1;
			//winCount가 0이고 0들어간 값도 다 꽝이라면 역시 꼴뜽인 6이 들어가야 한다.
			if(rank[i]==minCount || minCount==0) answer[1] = i+1;
		}
	
        return answer;
    }

}
