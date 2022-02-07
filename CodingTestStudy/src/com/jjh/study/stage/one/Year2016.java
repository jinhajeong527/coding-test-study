package com.jjh.study.stage.one;

public class Year2016 {
	public String solution(int a, int b) {

		int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] days = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int sum =0;
		//1월 일때는 b 값만 sum에 더해져야 하므로, 길이는 a-1이 된다.
		for(int i=0; i<a-1; i++) {
			sum += months[i];
		}
		sum += b;

		int index = sum%7;//0,1,2,3,4,5,6 이렇게 나올 것.
		if(index ==0) index =7; //index=0일 때는 -1 해주면 존재하지 않는 인덱스에 접근하게 되므로 7로 바꿔준다.

		return days[index-1];
    }

}
