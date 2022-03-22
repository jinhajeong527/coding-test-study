package com.jjh.study.leet.easy.dynamic;

public class MaximumSubarray2 {
	public static void main(String[] args) {
		MaximumSubarray2 ms = new MaximumSubarray2();
		ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
	}
	//시간복잡도 O(n)
	public int maxSubArray(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		
		for(int i=0; i<nums.length; i++) {
			currSum += nums[i];
			if(currSum > maxSum) {
				maxSum = currSum;
			}
			if(currSum < 0) {
				currSum = 0;
			}
			
		}
		return maxSum;
		
	}

}
