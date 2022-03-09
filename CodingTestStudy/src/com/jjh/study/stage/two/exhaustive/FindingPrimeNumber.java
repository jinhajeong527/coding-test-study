package com.jjh.study.stage.two.exhaustive;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//소수 찾기
public class FindingPrimeNumber {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[7]; //1이상 7이하의 길이 가지므로
    static int answer = 0;
    public static void main(String[] args) {
        FindingPrimeNumber fp = new FindingPrimeNumber();
        fp.solution("117");
    }

    public int solution(String numbers) {

        String temp = "";

        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, temp, i + 1);
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            //각 정수들이 소수인지 판별.
            cal(iterator.next());
        }
        return answer;

    }
    public static void cal(int n){
        // 16. 0과 1은 소수가 아니므로 바로 종료.
        if(n == 0) return;
        if(n == 1) return;

        // 17. 2~n의 제곱근까지 돌면서 나누어 떨어지면 소수가 아니므로 메소드 종료.
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return;
        }

        // 18. 모두 나누어 떨어지지 않으면 소수이므로 answer 증가.
        answer++;

    }


    public void dfs(String numbers, String temp, int length) {

        if (temp.length() == length) {
            if (!set.contains(Integer.parseInt(temp))) {
                //System.out.println(temp);
                set.add(Integer.parseInt(temp));
                return;
            }
        }
        for (int j = 0; j < numbers.length(); j++) {

            if (visited[j])//방문 했으면 다음 인덱스로 넘어간다.
                continue;
            visited[j] = true;// 방문 표시 해준다.
            StringBuilder sb = new StringBuilder(temp);
            sb.append(numbers.charAt(j));
            dfs(numbers, sb.toString(), length);
            //조합이 완료되면 직전의 방문처리한 인덱스를 false로 변경
            visited[j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}

