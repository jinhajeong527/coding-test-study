package com.jjh.study.stage.one;

import java.util.*;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        //예_ [2, 1, 2, 6, 2, 4, 3, 3]
        //분모값 측정에 쓰기 위해 stages 길이를 구한다.
        int length = stages.length;
        // 오름차순으로 sorting 한다.
        Arrays.sort(stages);

        // 각 stage마다 몇명이 도전 중인지를 카운트한 값을 담는다.
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i=1; i<=N+1; i++) {
            int count = 0;
            while(stages[index]==i){
                count++;
                if(index ==length-1) break;
                index++;
            }
                list.add(count);
        }
        //리스트에 이렇게 담길 것이다: [1, 3, 2, 1, 0, 1]
        //실패율 계산 값 담을 인트 배열을 선언한다.
        Double[] failureRate = new Double[list.size()-1];
        ArrayList<Double> duplicateRate = new ArrayList<>();
        /*
         원래는 똑같이 Double[] 배열로 선언하고 failureRate값 복사해주었는데,
         그럼 sorting 한면 그 코드 밑에있어도 그대로 정렬같이 되어서 리스트 형으로 선언함
         */


        int sum =0;
        /* 실패율 구하기
         분자 값은 해당 번호 도전 중인 사람이므로 카운트 값이 된다.
         분모 값은 전 인덱스의 카운트 값만 전체 값에서 빼주면 된다. */
        for(int i=0; i<list.size()-1; i++) {
            //{1, 1, 1, 1, 1, 1, 1, 1} 와 같은 예시가 있다면,
            // 그 후에는 분모가 0이 될 수 있으므로 값이 NaN으로 나오는 것을 막기위해 작성해 주었다.
            if(length-sum==0) {
                failureRate[i] =0.0;
                duplicateRate.add(0.0);
            }else {
                failureRate[i] = (double) list.get(i) / (length - sum);
                duplicateRate.add((double) list.get(i) / (length - sum));
            }
            sum += list.get(i);
        }
        //실패율 오름 차순으로 정렬.
        Arrays.sort(failureRate, Collections.reverseOrder());

        int[] answer = new int[failureRate.length];

        for(int i =0; i<failureRate.length; i++){
            for(int j=0; j <duplicateRate.size(); j++){
                if(failureRate[i].doubleValue() == duplicateRate.get(j)) {
                    answer[i] = j+1;
                    duplicateRate.set(j, -1.0);
                    /*
                    다시 이 값 쓰이지 않도록 다른 값을 넣어준다.
                    같은 실패율일시에 작은 스테이지 먼저 출력되어야 하기 때문이다
                     */
                    break;
                }
            }
        }
        return answer;
    }
}
