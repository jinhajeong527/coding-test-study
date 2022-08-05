package com.jjh.study.leet.easy;

import java.util.Arrays;
import java.util.Collections;

public class ThirdMaximumNumber {
	public static void main(String[] args) {
		ThirdMaximumNumber tm = new ThirdMaximumNumber();
		System.out.println(tm.thirdMax(new int[] {2,2,3, 1}));
	}
	public int thirdMax(int[] nums) {
		Integer[] arr = new Integer[nums.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = nums[i];
		}
		
		int count = 1;
		Arrays.sort(arr, Collections.reverseOrder());
		int max = arr[0];
		int prev = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < prev) {
				count++;
				prev = arr[i];
				if(count == 3) return arr[i];
			}
		}
        return max;
    }
}
