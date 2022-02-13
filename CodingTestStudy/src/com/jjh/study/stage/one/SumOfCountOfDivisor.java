package com.jjh.study.stage.one;

import java.util.ArrayList;

//프로그래머스 1단계: 약수의 개수와 덧셈
public class SumOfCountOfDivisor {
    public int solution(int left, int right) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            int count =0;
            int index = i;
            for(int j=1; j<=index ; j++) {
                if(i%j == 0) {
                        count ++;
                        // 4*4 같은 수가 아니라면 개수 하나 더 추가해준다.
                        if(!((i/j)*(i/j)==i)){
                            count ++;
                        }
                        index = i/j;//검색 범위를 줄여준다.
                }
            }
            list.add(count);
        }
        int initial = left;

        for(int i=0; i<list.size(); i++){

            if(list.get(i)%2==0){
                //개수가 짝수면 더해준다.
                answer += initial;
            }else{ //개수가 홀수이면
                answer -= initial;
            }
            initial ++;
        }

        return answer;
    }
}
