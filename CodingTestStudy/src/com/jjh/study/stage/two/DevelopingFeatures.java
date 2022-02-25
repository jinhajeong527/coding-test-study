package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//기능 개발
public class DevelopingFeatures {
	public int[] solution(int[] progresses, int[] speeds) {
		
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<>(); // LIFO
		
		//기능 개발이 완료되기 까지 걸리는 시간을 마지막 기능부터 계산한다.
		for(int i=progresses.length-1; i >= 0; i--) {
			int days = 0;
			while(progresses[i] < 100) {
				progresses[i] += speeds[i];
				days++;
			}
			stack.push(days);
		}
		
		while(!stack.isEmpty()) {
			int count = 1;
			int top = stack.pop();
			while(!stack.isEmpty() && stack.peek() <= top) {
				stack.pop();
				count++;
			}
			list.add(count);
		}
		
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

}
