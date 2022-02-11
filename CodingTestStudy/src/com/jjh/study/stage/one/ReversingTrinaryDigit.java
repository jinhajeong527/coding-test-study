package com.jjh.study.stage.one;

public class ReversingTrinaryDigit {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        //원래 while 안에 조건문을 n%3 !=1 을 했는데,
        //이 경우에는 최대 1억까지 나올 수 있는 n의 값을
        //while 값이 도는 동안에 계속해서 연산해야 되기 때문에 시간초과로 통과하지 못한 것으로 판단된다.
        while(true){ //true 로 만들고 n < 3이 되면, 빠져나온다.
            if(n<3) {sb.insert(0,n); break;}
            sb.insert(0,n%3);
            n = n/3;
        }
        String sbStr = sb.toString();
        StringBuffer sbReversed = new StringBuffer();

        for(int i=0; i<sbStr.length(); i++) {
            answer += Character.getNumericValue(sbStr.charAt(i)) * Math.pow(3, i);
        }
        return answer;
    }
}
