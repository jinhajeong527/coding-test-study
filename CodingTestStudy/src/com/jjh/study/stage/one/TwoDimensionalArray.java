package com.jjh.study.stage.one;

//프로그러매스 1단계 행렬의 덧셈 
public class TwoDimensionalArray {

	public int[][] solution(int[][] arr1, int[][] arr2) {

	        int[][] answer = {};
	        answer = new int[arr1.length][arr1[0].length];
	        for(int i=0;i < arr1.length; i++) {
				for (int j = 0; j < arr1[i].length; j++) {
					answer[i][j] = arr1[i][j] + arr2[i][j];

				}
			}
		return answer;
	}

}
