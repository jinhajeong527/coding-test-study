package com.jjh.study.leet.easy.dynamic;

public class MaximumSubarray {
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
	}
	//시간복잡도 O(n^2)
	public int maxSubArray(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		
		
		for(int i=0; i<nums.length; i++) {
			int currSum = 0;
			for(int j=i; j<nums.length; j++) {
				currSum += nums[j];
				if(maxSum < currSum) maxSum = currSum;
			}
		}
		return maxSum;
	}

}
