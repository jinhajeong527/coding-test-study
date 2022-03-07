package com.jjh.study.stage.two.exhaustive;

//카펫
public class Carpet {
	
	public int[] solution(int brown, int yellow) {
		int[] answer = {};
		boolean hasAnswer = false;
		for(int i=1; i<=yellow; i++) {
			if(yellow%i==0) { //이 때 직사각형 만들어 본다.
				int x = yellow/i;
				int y = yellow/x;
				if((x+2)*2 + 2*y == brown) { //해당 직사각형 만들었을 때 둘러지는 갈색 격자무늬 카펫 개수가 주어진 값과 일치하는지 확인한다.
					//가로의 길이는 세로보다 같거나 길다.
					answer = x > y ? new int[] {x+2, y+2} : new int[]{y+2, x+2};
					hasAnswer = true;
					break;
				}
			}
			//답 나왔으면 for문 더이상 돌지 않고 break
			if(hasAnswer) break;
		}
       
        return answer;
    }
}
