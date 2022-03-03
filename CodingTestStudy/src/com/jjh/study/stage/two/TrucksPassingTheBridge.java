package com.jjh.study.stage.two;


import java.util.LinkedList;
import java.util.Queue;

//다리를 지나는 트럭
public class TrucksPassingTheBridge {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
       
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int sumWeight = 0;//현재 다리가 버티고 있는 무게
        int truckTotal = truck_weights.length;//전체 트럭개수
        
        for(int i=0; i<truckTotal; i++) {
        	while(true) {
        		if(queue.isEmpty()) { //비어있으면 다리에 올린다.
            		queue.add(truck_weights[i]);
            		time++;
            		sumWeight += truck_weights[i];
            		break;
            	}else if(queue.size()==bridge_length) { //다리길이 꽉 찼다면 
            		sumWeight -= queue.poll();
            	}else { //다리길이 차지도 않고 비어있지도 않다면
            		if(sumWeight+truck_weights[i]<=weight) {
            			queue.add(truck_weights[i]);
                		time++;
                		sumWeight += truck_weights[i];
                		break;
            		}else { //다리 길이상으로는 괜찮지만 무게때문에 못올린다면
            			queue.add(0); //이동
            			time++;
            		}
            		
            	}
        	}
        }
      
        
        return time+bridge_length;
    }

}
