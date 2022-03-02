package com.jjh.study.stage.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TrucksPassingTheBridge {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		
        int answer = 0;
        Arrays.sort(truck_weights);
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int truckOnBg = 0;
        int weightOnBg = 0;
        for(int i=0; i<truck_weights.length; i++) {
        	if(queue.isEmpty()) { //비어있으면 다리에 올린다.
        		queue.add(truck_weights[i]);
        		time++;
        		truckOnBg++;
        		weightOnBg = truck_weights[i];
        	}else { //비어있지 않으면 다음거 하나더 올릴 수 있는지 확인한다.
        		while((weightOnBg < weight) && (truckOnBg <  bridge_length) && (i+1 <truck_weights.length)) {
        			
        		}
        		
        	}
        }
        
        
        return answer;
    }

}
