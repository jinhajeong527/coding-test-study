package com.jjh.study.stage.one;

public class CaesarCipher {
    public String solution(String s, int n) {
        int[] intArr = new int[s.length()];
        String answer = "";
        //대문자 아스키는 65-90
        //소문자 아스키는 97-122
        //공백은 32
        for(int i =0; i < s.length(); i++){
            intArr[i] = (int)s.charAt(i);
        }
        for(int i  =0; i<intArr.length; i++){
            if(intArr[i] !=32) {//공백인 경우 제외하고 n 값만큼 밀어주기
                if(intArr[i]+n > 90 && intArr[i]<=90){//대문자가 Z값 초과했을 경우
                    //소문자는 이쪽로직 타지 않게 하기 위해서 intArr[i]<=90 조건 추가함.
                    intArr[i] =  65 + (intArr[i]+n-90-1);
                }else if(intArr[i]+n > 122) { //소문자가 z 값 초과했을 경우
                    intArr[i]  = 97 + (intArr[i]+n-122-1);
                }else{
                    intArr[i] = intArr[i]+n;
                }
            }
            answer += Character.toString((char)intArr[i]);
        }
        return answer;
    }
}
