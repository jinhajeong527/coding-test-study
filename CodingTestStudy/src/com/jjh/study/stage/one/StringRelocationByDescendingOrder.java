package com.jjh.study.stage.one;

import java.util.Arrays;
import java.util.Collections;


public class StringRelocationByDescendingOrder {
    public String solution(String s) {

        String answer = "";

        //reverseOrder() 하기 위해서 인티저로 받아옴.
        Integer[] integerArr  =new Integer[s.length()];

        for(int i=0; i<s.length();i++){
            //문자를 아스키 값으로 변환하기 위해 char를 int로 캐스트 한다.
            integerArr[i] = (int)s.charAt(i);
        }

        //내림차순으로 정렬.
        Arrays.sort(integerArr, Collections.reverseOrder());

        //char 캐스팅을 해주기 위해 인트 배열로 다시 받는다.
        int[] intArr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
        char[] chars = new char[s.length()];

        for(int i =0;i<chars.length;i++){
            chars[i] =(char)intArr[i];
            answer += Character.toString(chars[i]);
        }
        return answer;
    }
}
