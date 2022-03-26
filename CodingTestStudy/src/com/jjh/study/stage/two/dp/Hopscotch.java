package com.jjh.study.stage.two.dp;

// 땅따먹기
// i번째 행들의 값들에 i-1번째까지의 행들의 값들의 최대값을 구해가는 식으로 해답을 찾는 동적 프로그래밍 문제이다.
// 동적프로그래밍: 문제의 크기가 작은 소문제에 대한 해를 테이블에 저장해놓고 이를 이용하여 크기가 보다 큰 문제의 해를 점진적으로 만들어가는 상향식 접근방법
public class Hopscotch {
	
	public static void main(String[] args) {
		Hopscotch hc = new Hopscotch();
		hc.solution(new int[][] { {1,2,3,5}, {5,6,7,8}, {4,3,2,1} });
	}
	
	
	
	int solution(int[][] land) {
		
        int answer = 0;
        
        for(int i = 1; i < land.length; i++) {
        	land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
        	land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
        	land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
        	land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
       
        for(int j = 0; j < land[0].length; j++) {
        	if(answer < land[land.length-1][j])
        		answer = land[land.length-1][j];
        }

        return answer;
    }

}
