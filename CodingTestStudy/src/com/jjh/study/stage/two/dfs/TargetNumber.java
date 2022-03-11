package com.jjh.study.stage.two.dfs;

//타겟 넘버
public class TargetNumber {
	int answer = 0;
	
	public int solution(int[] numbers, int target) {
		//depth와 합계 값은 0에서 시작한다.
        dfs(numbers, target, 0, 0);
        return answer;
    }
	//depth: 탐색의 깊이는 numbers.length 만큼 한다.
	public void dfs(int[] numbers, int target, int depth, int sum) {
		if(depth == numbers.length) { //마지막 노드까지 탐색한 경우
			if(sum == target) answer++;
		} else {
			dfs(numbers, target, depth+1, sum+numbers[depth]);
			dfs(numbers, target, depth+1, sum-numbers[depth]);
		}
	}
}
