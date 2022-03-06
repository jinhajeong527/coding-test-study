package com.jjh.study.stage.two;

import java.util.HashMap;

//영어 끝말잇기
public class EnglishWordChain {

    public int[] solution(int n, String[] words) {
        int turn = 1;
        String prev ="";
        int[] answer = {}; // 번호, 차례
        HashMap<String, Boolean> map = new HashMap<>();

        for(int i = 0; i < words.length ; i++) {
            if(i > 0 && i%n == 0) turn++; //새로운 턴마다 일씩 더해준다.

            if(i == 0 && words[i].length() != 1) { // 0일떈 일단 맵에 넣는다.
                map.put(words[i], true);
                prev = words[0].substring(words[0].length()-1); //다음 끝말잇기가 이 문자로 시작하는지 확인하기 위해 값 얻어온다.
            }else {
                if(words[i].startsWith(prev) && !map.containsKey(words[i])) {
                    prev = words[i].substring(words[i].length()-1);
                    map.put(words[i], true);
                }else if(!words[i].startsWith(prev) || map.containsKey(words[i])
                         || words[i].length() == 1) {
                    answer = new int[]{i % n + 1, turn};
                    return answer;
                }
            }

        }
        //여기까지 왔으면 탈락한 사람이 없었다는 뜻이 된다.
        return new int[]{0,0};
    }
}
