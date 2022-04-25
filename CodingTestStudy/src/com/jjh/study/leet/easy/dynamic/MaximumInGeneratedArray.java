package com.jjh.study.leet.easy.dynamic;

//Get Maximum in Generated Array
public class MaximumInGeneratedArray {
	public int getMaximumGenerated(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		int max = 1;
		for(int i = 2; i <= n; i++) {
			if(i % 2 == 0) arr[(i/2)*2] = arr[i/2];
			else if(i % 2 == 1) arr[(i/2)*2+1] = arr[i/2] + arr[i/2 +1];
			if (max < arr[i]) max = arr[i];
		}
		return max;   
    }

}
