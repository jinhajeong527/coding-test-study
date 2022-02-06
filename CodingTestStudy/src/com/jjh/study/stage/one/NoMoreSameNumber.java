package com.jjh.study.stage.one;

import java.util.ArrayList;

/* 프로그래머스 같은 숫자는 싫어 */
public class NoMoreSameNumber {
    public int[] solution(int[] arr) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        //0번 인덱스 값을 제일 먼저 비교하게 될 것이므로 심어준다.
        int compareNum = arr[0];
        //리스트에 추가해준다.
        list.add(compareNum);
        for(int i=1; i<arr.length; i++) {
            if(compareNum!=arr[i]){//비교 값과 같지 않을 때만 리스트에 add() 한다.
               list.add(arr[i]);
            }
               compareNum = arr[i];
        }
        int[] answer= list.stream().mapToInt(Integer::intValue).toArray();//ArrayList<Integer> to int[]
        return answer;
    }
}
