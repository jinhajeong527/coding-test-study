package com.jjh.study.stage.one;

//키패드 누르기
public class PressingDownKeypad {
	public String solution(int[] numbers, String hand) {
		
		int count1 =1;
		int count2 =0;
		StringBuilder sb = new StringBuilder();
		int[][] array = new int[12][2];
		for(int i=0; i < array.length; i++) {
			if(i>0 && i%3==0) count1++;
			count2++;
			for(int j=0; j<array[i].length;j++) {
				if(j==0) array[i][j] = count1;
				if(j==1) array[i][j] = count2;
			}
			if(count2==3) count2 =0;
		}
		
		int[] lefty = array[9];
		int[] righty = array[11];
		for(int i=0; i< numbers.length; i++) {
			
		}
		
        String answer = "";
        return answer;
    }

}
