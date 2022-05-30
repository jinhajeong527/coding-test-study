package com.jjh.study.leet.easy.greedy;

public class PartitionArrayIntoThreePartsWithEqualSum {
	public static void main(String[] args) {
		PartitionArrayIntoThreePartsWithEqualSum pa = new PartitionArrayIntoThreePartsWithEqualSum();
		pa.canThreePartsEqualSum(new int[] { 18, 12, -18, 18, -19, -1, 10, 10 });
	}
	
	public boolean canThreePartsEqualSum(int[] arr) {
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i]; 
		}
		
		int avg = (sum / 3);
		
		int part = 0;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			part += arr[i];
			if(part == avg) {
				count++;
				part = 0;
			}
		}

		return (count >= 3 && sum % 3 == 0);
	}

}
