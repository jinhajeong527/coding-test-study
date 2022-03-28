package com.jjh.study.stage.two.dp;

//가장 큰 정사각형 찾기
public class BiggestSquare {

    public int solution(int[][] board) {
        //행이 1이거나 열이 1인 경우를 고려하여 크기가 좌우측 1씩 더 긴 이차원 배열 새로 생성해서 기존 값 복사해준다.
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                newBoard[i+1][j+1] = board[i][j];

        int maxLen = 0;

        for(int i = 1; i < newBoard.length; i++)
            for(int j = 1; j < newBoard[0].length; j++) {
                //현재 값이 1이 아닌 경우에는 ←, ↑, ↖  모두 체크한다 하여도 크기가 1인 정사각형밖에 만들지 못하기에
                //1인 경우에 체크해서 한변의 길이가 2인 정사각형 만들 수 있는지 확인한다.
                if(newBoard[i][j] == 1) {
                int left = newBoard[i-1][j];
                int top = newBoard[i][j-1];
                int leftTop = newBoard[i-1][j-1];
                //하나라도 0이 있으면 길이 2인 정사각형 못 만든다.
                int min = Math.min(left, Math.min(top, leftTop));
                newBoard[i][j] = min + 1;
                maxLen = Math.max(maxLen, min + 1);
                }
            }
        return maxLen * maxLen;
    }
}
