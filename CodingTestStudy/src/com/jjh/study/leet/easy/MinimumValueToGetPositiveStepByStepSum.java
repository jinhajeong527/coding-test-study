package com.jjh.study.leet.easy;

public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        MinimumValueToGetPositiveStepByStepSum ms = new MinimumValueToGetPositiveStepByStepSum();
        ms.minStartValue(new int[]{-3,2,-3,4,2});
    }
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = startValue;//가장 작은 양의 정수 1로 시작한다.
        for(int i=0; i<nums.length; i++) {
           sum += nums[i];
           if(sum < 1) { //합이 1보다 작으면
               while(true) {
                   sum+=1; //1보다 커질 때까지 sum에 1을 더해주고, 시작 값을 1씩 더해준다.
                   startValue++;
                   if(sum >= 1) break;
               }
           }
        }
        return startValue;
    }
}
