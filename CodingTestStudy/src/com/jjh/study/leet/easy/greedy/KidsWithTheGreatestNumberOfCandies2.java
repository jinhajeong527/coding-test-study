package com.jjh.study.leet.easy.greedy;

import java.util.ArrayList;
import java.util.List;

//시간복잡도 O(n)으로 풀어보기
public class KidsWithTheGreatestNumberOfCandies2 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

       int max = candies[0];
       //max 값을 구한다.
       for(int i = 1; i < candies.length; i++) {
            if(candies[i] > max) max = candies[i];
       }
       List<Boolean> list = new ArrayList<>();

       for(int i = 0; i < candies.length; i++) {
           list.add(candies[i] + extraCandies >= max);
       }
        return list;
    }
}
