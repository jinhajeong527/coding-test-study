package com.jjh.study.stage.one;


public class MakingWeirdWords {
    public String solution(String s) {
        int index = 0;
        StringBuilder builder = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                index =0;
            }else if(index%2==0){
                builder.setCharAt(i,Character.toUpperCase(s.charAt(i)));
                index++;
            }else if(index%2==1){
                builder.setCharAt(i,Character.toLowerCase(s.charAt(i)));
                index++;
            }
        }

        String answer = builder.toString();
        return answer;
    }
}
