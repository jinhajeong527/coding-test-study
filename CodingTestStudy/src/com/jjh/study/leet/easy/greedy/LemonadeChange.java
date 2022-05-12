package com.jjh.study.leet.easy.greedy;

import java.util.HashMap;

public class LemonadeChange {
	public static void main(String[] args) {
		LemonadeChange lc = new LemonadeChange();
		lc.lemonadeChange(new int[] { 5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5 });
	}
	
	public boolean lemonadeChange(int[] bills) {
		
		int currentChange = 0;
		if(bills[0] > 5) return false;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(5, 0);
		map.put(10, 0);
		map.put(20, 0);
		
		for(int i = 0; i < bills.length; i++) {
			
			if(bills[i] == 5) { // 5달러 주면 거슬러줄 필요가 없음.
				map.put(5, map.get(5) + 1);
				currentChange += 5; //전체 잔액 추가하기
			}
			else { // 10달러나 20달러 냈을 경우
				//일단 잔액 부족하면 무조건 false 리턴한다.
				if((bills[i] - 5) > currentChange) {
					return false;
				}
				
				//잔액은 부족하지 않을 때
				else {
					if(bills[i] == 10 && map.get(5) >= 1) {
						map.put(10, map.get(10) + 1);
						map.put(5,  map.get(5) - 1);
					} 
					else if(bills[i] == 20 && map.get(5) >= 1 && map.get(10) >= 1) {
						map.put(20, map.get(20) + 1);
						map.put(10, map.get(10) - 1);
						map.put(5,  map.get(5) - 1);
					} 
					else if(bills[i] == 20 && map.get(5) >= 3) {
						map.put(20, map.get(20) + 1);
						map.put(5,  map.get(5) - 3);
					}
					else {
						return false;
					}
					
					currentChange = currentChange + bills[i] + (bills[i] - 5); 
				}
			}
		}
		return true;
    }
}
