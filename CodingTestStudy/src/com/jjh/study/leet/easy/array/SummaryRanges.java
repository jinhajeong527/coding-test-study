package com.jjh.study.leet.easy.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        sr.summaryRanges(new int[]{0,1,2,4,5,7});
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        String str ="";
        boolean isInRange = false;
        for(int i=0; i < nums.length; i++) {
            //우선 스트링으로 바꿔준다.
            str = Integer.toString(nums[i]);
            while((i+1)< nums.length &&nums[i]+1==nums[i+1] ) {
                //인덱스 범위를 벗어나지 않으면서 num[i+1]이 그 전의 값보다 1만큼 큰동안 while문 돌린다.
                isInRange = true;
                i++;
            }
            if(isInRange) {
                str += "->"+nums[i];
                isInRange = false; //다음에 또 있을 range값을 위해 false로 바꿔준다.
            }
            list.add(str);

        }

        return list;
    }
}
