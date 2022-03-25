package com.jjh.study.stage.two;

//최대값과 최소값
public class MaximumAndMinimumValue {
	public static void main(String[] args) {
		MaximumAndMinimumValue mm = new MaximumAndMinimumValue();
		mm.solution("-1 2 3 4");
	}
	public String solution(String s) {
		String[] strArr = s.split("\\s");
		int[] intArr = new int[strArr.length];
		int max = 0;
		int min = 0;
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
			if(i==0) {
				max = intArr[i];
				min = intArr[i];
			}else {
				if(max < intArr[i]) max = intArr[i];
				else if(min > intArr[i]) min = intArr[i];
			}
			
		}
        String answer =min+" "+max;
        return answer;
    }
}
