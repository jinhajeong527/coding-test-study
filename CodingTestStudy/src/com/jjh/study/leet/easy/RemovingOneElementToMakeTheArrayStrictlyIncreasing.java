package com.jjh.study.leet.easy;

// 1909. Remove One Element to Make the Array Strictly Increasing
public class RemovingOneElementToMakeTheArrayStrictlyIncreasing {
	public boolean canBeIncreasing(int[] nums) {
		int count = 0;
		int p = 0;
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i] >= nums[i+1]) {
				// 더 앞에 있는 인덱스의 값이 뒤의 인덱스에 있는 값보다 같거나 클 경우 count 올려주고 해당 위치 변수 p에 기록한다.
				count++;
				p = i;
			}
		}
		// 딱 하나의 값만 지워서 계속 상승하는 배열을 만들 수 있을 때 true를 리턴하기 때문에 count가 1을 초과한다면 false를 리턴한다.
		if(count > 1) return false;
		else if(count == 1) {
			// 맨 앞에서 혹은 맨 뒤의 하나 앞에서 삭제할 값이 발생했을 경우 그 값만 삭제해주면 되기에 true 리턴한다.
			if(p == 0 || p == nums.length - 2) return true;
			// 첫 번째의 경우는 p인덱스의 num 값을 삭제해주면 되고, 두번째는 nums[p+1] 값을 삭제해주면 된다.
			if(nums[p+1] > nums[p-1] || nums[p+2] > nums[p]) return true;
			else return false;
		}
		return true;
    }
}
