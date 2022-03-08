package com.jjh.study.stage.two;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	public static void main(String[] args) {
		Cache ch = new Cache();
		ch.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
	}
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int capacity = 0;
        Queue<String> queue = new LinkedList<>();
        
        if(cacheSize == 0) { //캐시 사이즈가 0인경우 cities는 길이만큼 매번 캐시 미싱이 되기 때문에 5*배열길이 해준다.
        	return 5*cities.length;
        }
        
        for(int i=0; i<cities.length; i++) {
        	if(queue.isEmpty()) {
        		queue.add(cities[i].toLowerCase());
        		capacity++;
        		answer += 5;
        	} else if(!queue.contains(cities[i].toLowerCase())) {
        		queue.add(cities[i].toLowerCase());
        		capacity++;
        		answer += 5;
        		if(capacity>cacheSize) { //캐시사이즈만큼 큐가 찼다면, LRU에 따라 맨 끝의 데이터를 빼준다.
        			queue.poll();
        			capacity--;
        		}
        	} else if(queue.contains(cities[i].toLowerCase())) { //캐시 히트인 경우
        		answer += 1;
        		queue.remove(cities[i].toLowerCase());//해당 값 최신 사용으로 업데이트 되어야 하기 때문에 지워준다.
        		queue.add(cities[i].toLowerCase());
        	}
        }
      
        return answer;
    }
}
