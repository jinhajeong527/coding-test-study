package com.jjh.study.stage.two;


import java.util.Arrays;
import java.util.Collections;

//최솟값 만들기
public class MakingMinimumValue {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        Arrays.sort(a);
        //내림차순의 정렬
        //b = Arrays.stream(b).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        //위의 방법은 네개 모두 효율성에서 시간 초과로 탈락했는데 밑에 것은 맨 마지막 하나만 효율성에서 탈락했다.
        /*
        Integer[] bArr = Arrays.stream(b).boxed().toArray(Integer[] :: new);
        Arrays.sort(bArr, Collections.reverseOrder());
        */
        /* 이건 두번째 효율성 코드가 시간 초과가 떴다
        Integer[] bArr = Arrays.stream(b).boxed().sorted(Collections.reverseOrder()).toArray(Integer[] :: new);
        */
        Arrays.sort(b);
        int n = a.length-1;
        for(int i = 0 ; i < a.length; i++) {
            answer += a[i]*b[n];
            n--;
        }
        return answer;
    }
}
