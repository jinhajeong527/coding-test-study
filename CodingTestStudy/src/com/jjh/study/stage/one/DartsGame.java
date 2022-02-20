package com.jjh.study.stage.one;


public class DartsGame {
    public int solution(String dartResult) {
        char[] resultChars = dartResult.toCharArray();
        int[] calArr = new int[3];//길이가 3인 배열에 선언해준다.
        int count = -1;// 숫자일 때마다 +1 해줄 것이기 때문에 count = -1; 로 초기화 해주었다.

        for(int i=0; i < resultChars.length ; i++){
            if(Character.isDigit(resultChars[i])){ //숫자인지 확인한다.
                count++; // +1 해준다.
                if(Character.isDigit(resultChars[i+1])){ //정수 10인지 체크해준다.
                    calArr[count] = 10;
                    i++; // index out of array exception 피해주기 위해서 i++ 해준다.
                }else {
                    calArr[count] = Integer.parseInt(Character.toString(resultChars[i]));
                }
            }else if(resultChars[i] == 'D'){
                calArr[count] =(int) Math.pow(calArr[count], 2);
            }else if(resultChars[i] == 'T'){
                calArr[count] =(int) Math.pow(calArr[count], 3);
            }else if(resultChars[i] == '*'){
                if(count>=1) calArr[count-1] *= 2; //앞의 계산 값도 *2 해주어야 한다.
                calArr[count] *= 2;
            }else if(resultChars[i]=='#'){
                calArr[count] *= -1;
            }
        }
        int sum =0;
        for(int num: calArr) sum += num;
        return sum;
    }

}
