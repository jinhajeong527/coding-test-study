package com.jjh.study.stage.two;

public class LcmOfNumbers {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            int gcd = gcd(answer, arr[i]);
            answer = answer*arr[i] /gcd;
        }

        return answer;
    }


    //최소공약수 메서드, 유클리드 호제법
    static int gcd(int a, int b) {
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        while(x % y !=0 ) {
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }
}
