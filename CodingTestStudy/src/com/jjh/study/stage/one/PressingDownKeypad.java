package com.jjh.study.stage.one;

//키패드 누르기
public class PressingDownKeypad {
	public String solution(int[] numbers, String hand) {
		
		int count1 =1;
		int count2 =0;
		StringBuilder sb = new StringBuilder();
		//키패드 번호에 따라 위치정보 저장할 것. 총 12개이고, {1,1}, {1,2} {1,3} {2,1}... 이렇게 만들어준다.
		int[][] array = new int[12][2];
		for(int i=0; i < array.length; i++) {
			if(i>0 && i%3==0) count1++;
			count2++;
			for(int j=0; j<array[i].length;j++) {
				if(j==0) array[i][j] = count1;
				if(j==1) array[i][j] = count2;
			}
			if(count2==3) count2 =0;
		}
//		for(int i=0; i<array.length; i++){
//			System.out.println(array[i][0]+","+array[i][1]);
//		}
		//왼손 시작위치
		int[] lefty = array[9];
		//오른손 시작위치
		int[] righty = array[11];
		int[] location = new int[2];
		for(int i=0; i< numbers.length; i++) {
			if(numbers[i]%3==1){//1,4,7
				sb.append("L");
				lefty = array[numbers[i]-1];
			}else if(numbers[i]%3==0 && numbers[i]!=0){//3,6,9
				sb.append("R");
				righty = array[numbers[i]-1];
			}else{//2,4,8,0
				if(numbers[i]==0){
					location = array[10];
				}else{
					location = array[numbers[i]-1];
				}
				int sum1 =0;
				int sum2 =0;
				for(int j=0;j<lefty.length; j++){
					sum1 += Math.abs(lefty[j]-location[j]);
					sum2 += Math.abs(righty[j]-location[j]);
				}
				if(sum1>sum2){
					sb.append("R");
					righty = location;
				}else if(sum1<sum2){
					sb.append("L");
					lefty = location;
				}else if(sum1==sum2){
					if(hand.equals("right")) {
						sb.append("R");
						righty = location;
					}else{
						sb.append("L");
						lefty = location;
					}
				}
			}
		}

        String answer = sb.toString();
        return answer;
    }

}
