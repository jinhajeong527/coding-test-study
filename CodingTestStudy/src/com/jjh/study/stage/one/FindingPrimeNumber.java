package com.jjh.study.stage.one;

public class FindingPrimeNumber {
    public int solution(int n) {
        int answer = 0;
        //10, 2,3,4,7 ==> 4개가 답으로 리턴되어야 한다.
        for(int i=2; i <= n; i++) {
            int count =0;
            boolean flag = true;
            //2부터 10까지 검사할 것이고
            for(int j =2; j <=Math.sqrt(i); j++){

                if(i%j==0) {
                    flag= false; break;
                }
            }
            if(flag==true){
                answer++;
            }
        }

        return answer;
    }
}
