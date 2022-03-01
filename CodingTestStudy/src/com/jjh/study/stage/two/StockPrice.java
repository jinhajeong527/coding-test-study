package com.jjh.study.stage.two;

import java.util.*;

//주식가격
public class StockPrice {

    public int[] solution(int[] prices) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<prices.length; i++) {
            boolean isAdded  = false;
            if(i==prices.length-1) { //배열의 마지막 데이터면 무조건 0초간 가격 유지이므로 0을 리스트에 추가하고 break;
                isAdded = true;
                list.add(0);
                break;
            }
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] > prices[j]) {
                    isAdded = true;
                    list.add(j-i);
                    break;
                }
            }
            //한번도 가격이 떨어지지 않은 경우는 마지막 인덱스의 길이에서 해당 가격의 인덱스를 뺴준만큼(즉 해당 인덱스의 전체 기간) 동안 가격 유지했다.
            if(isAdded==false) list.add(prices.length-1-i);
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }
}
