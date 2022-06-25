package com.jjh.study.stage.two.dfs;

// 프로그래머스 2단계 : 단체사진 찍기
public class TakingGroupPhoto {
    public static void main(String[] args) {
        TakingGroupPhoto tgp = new TakingGroupPhoto();
        int answer = tgp.solution(2, new String[]{"N~F=0", "R~T>2"});
        System.out.println(answer);
    }
    // 단체사진 찍으려는 카카오 프렌즈들의 char 배열
    char[] friends = new char[]{ 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
    int answer = 0;

    public int solution(int n, String[] data) {
        // 카카오 프렌즈의 모든 수 만큼 순열 조합 만들 것이기 때문에 visited 길이를 friends.length로 해준다.
        boolean[] visited = new boolean[friends.length];
        dfs("", data, visited);
        return answer;
    }

    private void dfs(String names, String[] data, boolean[] visited) {
        if(names.length() == 8) {
            if(checkIfThisWayWorks(names, data)) {
                answer++;
            }
            return;
        }
        for(int i = 0; i < friends.length; i++) {
            if(!visited[i]) { // 방문한 적 없으면 순열에 추가해주고 방문 true로 셋팅 후 다시 dsf 순환 호출, 그리고 다시 방문 한적 없다는 표시로 false로 해준다.
                String name = names + friends[i];
                visited[i] = true;
                dfs(name, data, visited);
                visited[i] = false;
            }
        }
    }

    private boolean checkIfThisWayWorks(String names, String[] data) {

        for(int i = 0; i < data.length; i++) {
            // 해당 프렌즈들이 names에서 어디에 위치해 있는지 인덱스 받아온다.
            int firstIndex = names.indexOf(data[i].charAt(0));
            int secondIndex = names.indexOf(data[i].charAt(2));
            // >, <, = 부등 호 중 무엇인지 받아온다.
            char symbol = data[i].charAt(3);
            // 둘 사이의 희망 거리 정보 받아온다.
            int distance = Integer.parseInt(data[i].charAt(4) + "");

            if(symbol == '=' && !(Math.abs(firstIndex - secondIndex) == distance + 1)) return false;
            else if(symbol == '>' && !(Math.abs(firstIndex - secondIndex) > distance + 1)) return false;
            else if(symbol == '<' && !(Math.abs(firstIndex - secondIndex) < distance + 1)) return false;
        }
        return true;
    }
}
