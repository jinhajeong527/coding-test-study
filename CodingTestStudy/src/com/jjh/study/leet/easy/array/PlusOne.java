package com.jjh.study.leet.easy.array;

public class PlusOne {
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		po.plusOne(new int[] {9});
	}
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		for(int i = length-1; i >= 0; i--) {
			if(digits[i]<9) { //9보다 작으면 단순히 1만 더해주면 된다.
				digits[i]++;
				return digits;
			}
			digits[i] = 0; //9보다 크면 0으로 값 초기화 해준다.
		}
		//여기까지 왔다는 것은 999와 같은 경우가 된다. 즉 1000을 리턴해야 하기 때문에 자리수가 1 추가된다.  
		int[] intArr = new int[digits.length+1];
		intArr[0] = 1;
	
        return intArr;
    }

}
