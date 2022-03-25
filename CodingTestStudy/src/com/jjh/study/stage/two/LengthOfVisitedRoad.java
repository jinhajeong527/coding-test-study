package com.jjh.study.stage.two;


//방문 길이
public class LengthOfVisitedRoad {
	public static void main(String[] args) {
		LengthOfVisitedRoad lv = new LengthOfVisitedRoad();
		lv.solution("ULURRDLLU");
	}
	
	public int solution(String dirs) {
		int answer = 0;
		
		int[] xArr = new int[]{ 0, 0, 1, -1 };// U, D, R, L의  x좌표 이동
		int[] yArr = new int[]{ -1, 1, 0, 0 };// U, D, R, L의  y좌표 이동: 맨위 왼쪽이 (-5, 5)의 좌표 위치이지만, 배열로 생각했을 때 위로 올라가면 배열의 y 값은 1이 줄어드는 것이 맞음.
		boolean[][][][] visited = new boolean[11][11][11][11];
		//이동 전의 위치
		int curX = 0;
		int curY = 0;
		//이동 후의 위치 => (0,0)을 표현한다.
		int nextX = 5;
		int nextY = 5;
		
		char[] strChar = dirs.toCharArray();
		int index = 0;
		for(int i=0; i < strChar.length; i++) {
			//현재 위치 저장하기
			curX = nextX;
			curY = nextY;
			if(strChar[i] =='U') index = 0;
			else if(strChar[i] == 'D') index = 1;
			else if(strChar[i] == 'R') index = 2;
			else if(strChar[i] == 'L') index = 3;
			
			nextX += xArr[index];
			nextY += yArr[index];
			
			if(nextX > 10 || nextX < 0 || nextY > 10|| nextY < 0) { //범위를 벗어났을 경우에 
				nextX -= xArr[index];
				nextY -= yArr[index];
				continue;
			}
			
			if(!visited[curX][curY][nextX][nextY] && !visited[nextX][nextY][curX][curY]) { //처음 방문한 길이라면
				visited[curX][curY][nextX][nextY] = true;
				visited[nextX][nextY][curX][curY] = true;
				answer++;
			}
			
		}
        return answer;
    }
}
