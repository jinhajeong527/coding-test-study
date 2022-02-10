package com.jjh.study.stage.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class AddAfterSelectingTwo {
    public int[] solution(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<numbers.length-1; i++){
            int j = i+1;
            while(j<=numbers.length-1){
                list.add(numbers[i]+numbers[j]);
                j++;
            }
        }

        //중복 제거를 해주기 위해 해쉬셋 만들어 준다.
        //값이 더해지는 과정에서 중복값 있을 수 있기 때문이다.
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);
        //중복 값 제거 후 다시 리스트에 넣어준다.
        ArrayList<Integer> list2 = new ArrayList<>(hashSet);
        //오름차순 정렬해준다.
        Collections.sort(list2);

        //ArrayList<Integer> to int[] 로 바꿔주기.
        int[] answer = list2.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
