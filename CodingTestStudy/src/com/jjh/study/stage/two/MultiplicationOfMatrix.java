package com.jjh.study.stage.two;

public class MultiplicationOfMatrix {
    public static void main(String[] args) {
        MultiplicationOfMatrix mm = new MultiplicationOfMatrix();
        mm.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        //두 행렬의 곱셈이 가능할 때 이차배열의 크기는 int[첫번째배열 행의 크기][두번째 배열 열의 크기];
        int[][] answer = new int[arr1.length][arr2[0].length];
        //answer[0][0]의 값 answer[0][1] 값 구하기 위해서 첫번째 배열 arr1의 arr1[0][0], arr1[0][1] 이 두 번 쓰인다.
        for(int i=0; i < arr1.length; i++) {
            for(int j=0; j < arr2[0].length; j++) {
                for(int k=0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
