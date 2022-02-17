package com.jjh.study.stage.one;

public class ClawCraneGame {
		public int solution(int[][] board, int[] moves) {
			//moves { 1, 5, 3, 5, 1, 2, 1, 4 }
			int length = board.length;
			int[] intArr = new int[length*length];
			int index =0;
			
			for(int i=0; i<moves.length; i++) {
				int location = moves[i]; //1
				for(int j=0; j<length; j++) {
					if(board[j][location-1]!=0) {
						intArr[index] = board[j][location-1];
						board[j][location-1] = 0;
						if(intArr.length>=2) {
							if(intArr[index]==intArr[index-1]) {
								//index = index
							}
						}
						
						
						index++;
						break;
					}
				}
			}
			
			
        int answer = 0;
        return answer;
    }
	
}
