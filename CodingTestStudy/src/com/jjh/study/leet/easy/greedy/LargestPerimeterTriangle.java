package com.jjh.study.leet.easy.greedy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
	public static void main(String[] args) {
		LargestPerimeterTriangle lpt = new LargestPerimeterTriangle();
		lpt.largestPerimeter(new int[] {1,1,3});
	}
	
	public int largestPerimeter(int[] nums) {
		
		Arrays.sort(nums);
		int largestPerimeter = 0;
		int bigLength = 0; 
		bigLength = nums[nums.length - 1];
		for(int i = nums.length -2 ; i >= 0 ; i--) {
			if(i-1 >= 0) {
				if(bigLength < nums[i] + nums[i-1]) return (bigLength + nums[i] + nums[i-1]);
				else { //삼각형 못만들 경우 제일 긴 길이 하나 줄인다.
					bigLength = nums[i];
				}
			}
		}
		// 삼각형 만들 수 없을 경우 0 리턴.
		return largestPerimeter;
    }
}
