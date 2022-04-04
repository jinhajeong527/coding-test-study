package com.jjh.study.leet.easy.greedy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //추가 캔디를 주었을 때의 캔디 개수 담은 인트 배열 만든다.
        int[] extras = new int[candies.length];

        for(int i = 0; i < candies.length; i++) {
          extras[i] = candies[i] + extraCandies;
        }
        List<Boolean> list = new ArrayList<>();

        for(int i = 0; i < candies.length; i++) {
            boolean isBiggest = true;
            for(int j = 0; j < candies.length; j++) {
                if(i == j) continue; //같은 인덱스일 땐 비교할 필요 없으므로 continue
                if(extras[i] < candies[j]) { //추가로 캔디 준 후에도 더 많이 가진 아이가 있을 경우
                    isBiggest = false;
                    break;
                }
            }
            if(isBiggest) list.add(true);
            else list.add(false);
        }
        return list;

    }
}
