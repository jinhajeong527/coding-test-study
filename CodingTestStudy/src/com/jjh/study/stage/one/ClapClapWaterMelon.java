package com.jjh.study.stage.one;

import java.util.Collections;

public class ClapClapWaterMelon {
    public String solution(int n) {
        String su = "수";
        String bak ="박";
        String answer = "";
        if(n%2==0){
           //answer = new String(new char[n%2]).replace("\0", su+bak);
            answer= String.join("", Collections.nCopies(n/2, su+bak));
        }else{
            //answer = new String(new char[n%2]).replace("\0", su+bak)+su;
            answer= String.join("", Collections.nCopies(n/2, su+bak))+su;
        }


        return answer;
    }

}
