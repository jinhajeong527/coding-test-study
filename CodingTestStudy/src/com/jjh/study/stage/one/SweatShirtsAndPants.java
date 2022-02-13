package com.jjh.study.stage.one;

import java.util.Arrays;

//프로그래머스 1단계: 체육복
public class SweatShirtsAndPants {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count  = 0;
        //문제에 오름차순 정렬이라는 말 없으므로 정렬해준다.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여분 있던 사람이 분실한 경우
        for(int i=0; i<lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    //더이상 빌려줄 수 없지만 체육수업엔 참여할 수 있으므로, reserve,lost 목록 둘다에서 빼준다.
                    count++;
                    lost[i] = -1;//여기 j로 했어서 에러가 났던 것.
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]-1==reserve[j] || lost[i]+1==reserve[j]) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        answer = n -lost.length +count;
        return answer;
    }
}
