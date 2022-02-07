package com.jjh.study.stage.one;

public class Year2016 {
	public String solution(int a, int b) {
		int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] days = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		//1월 1일
		//월에서는 아무것도 가져오면 안되고, +b 하면 1보다 작다.. 총 값은 1이 된다.
		int sum =0;
		
		for(int i=0; i<a-1; i++) {
			sum += months[i];
		}
		System.out.println(sum);//121
		sum += b;//145
		//2016년 2월 1일 월요일 sum은 32..
		int index = 32%7;//4...
		System.out.println(index);
		String answer = days[index];
		System.out.println(answer);
		return answer;
    }

}
