package com.jjh.study.stage.two;


//다음 큰 숫자
public class NextBiggerNumber {

    public int solution(int n) {

        int oneCount = 0;
        //n을 이진수로 변환한 다음에 1의 개수를 센값을 구한다.
        oneCount = countOneNumber(n);

        int nextBiggerNum = n + 1;

        while(true) {
            int count = countOneNumber(nextBiggerNum);
            if(count == oneCount) break;
            nextBiggerNum++;
        }

        int answer = nextBiggerNum;
        return answer;
    }

    public int countOneNumber(int number){
        int oneCount = 0;

        while(true) {
            int r = number % 2;
            if(r==1) oneCount++;
            number /= 2;
            if(number==0) break;
        }
        return oneCount;
    }
}
