package com.jjh.study.stage.one;

import java.util.Arrays;

public class OrganizingStringsByIntegerN {
    public String[] solution(String[] strings, int n) {
        //주어진 스트링 길이만큼 인트 배열의 크기를 선언한다.
        String[] answer = new String[strings.length];

        for(int i =0 ;i<answer.length;i++){
            answer[i] = Character.toString(strings[i].charAt(n)) + strings[i];
        }
        Arrays.sort(answer);
        for(int i =0 ;i<answer.length;i++){
            answer[i] = answer[i].substring(1);
        }

        return answer;
    }
}
