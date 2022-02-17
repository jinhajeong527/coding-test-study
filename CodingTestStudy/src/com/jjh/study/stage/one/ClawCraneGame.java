package com.jjh.study.stage.one;

import java.util.Arrays;

public class ClawCraneGame {
		public int solution(int[][] board, int[] moves) {
			//moves { 1, 5, 3, 5, 1, 2, 1, 4 }
			int length = board.length;
			int[] intArr = new int[1];//길이는 1부터 시작한다.
			int index =0;
			int answer = 0;
			for(int i=0; i < moves.length; i++) {//어떤 크레인 넘버로 갈지 moves 다 돌려본다.
				int location = moves[i];
				for(int j=0; j < length; j++) {
					if(board[j][location-1] != 0) {//0이 아닐 때 인형이 있는거니까 집어서 바구니에 넣어야 한다.
						try{
							intArr[index] = board[j][location-1];
						} catch(Exception e) {//1개로 길이 고정이라서 2번째거 바구니에 넣으면 에러날 것.
							intArr = Arrays.copyOf(intArr, intArr.length + 1);
							intArr[index] = board[j][location-1];
						}
						board[j][location-1] = 0;//뽑아갔으니까 비워준다.
						if(intArr.length >= 2) { //인형 바구니가 두개 이상이면, 똑같은거 있는지 체크해준다.
							if(intArr[index] == intArr[index-1]) {
								index = index-2;
								answer = answer +2;
							}
						}
						index++;//처음 2개 똑같아서 터뜨렸어도 여기서 더해주어서 다시 0부터 값 넣어주기 떄문에 괜찮다.
						break;
					}

				}
			}

        return answer;
    }
	
}
