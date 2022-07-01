package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.Collections;

public class ArcheryContest {
    static int max = -1000;
    static int[] answer = { -1 };
    static int[] ryan;
    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        dfs(info, 1, n);
        return answer;
    }

    public void dfs(int[] info, int count, int n ) {
        if(count == n + 1) {
            int apeachScore = 0;
            int ryanScore = 0;
            for(int i = 0; i <= 10; i++) {
                if(info[i] != 0 || ryan[i] != 0) { // ryan[i] != 0 이 조건 순서가 앞으로 가면 6번 22번 테스트케이스 시간 초과 발생함
                    if(ryan[i] > info[i]) ryanScore += 10 - i;
                    else apeachScore += 10 - i;
                }
            }
            if(ryanScore > apeachScore) {
                if(ryanScore - apeachScore >= max) {
                    max = ryanScore - apeachScore;
                    answer = ryan.clone();
                }

            }
            return;
        }


        for(int j = 0; j <= 10 && ryan[j] <= info[j]; j++) {
            ryan[j]++;
            dfs(info, count + 1, n);
            ryan[j]--;
        }

    }
}

