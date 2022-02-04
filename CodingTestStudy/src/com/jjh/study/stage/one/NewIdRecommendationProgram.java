package com.jjh.study.stage.one;

public class NewIdRecommendationProgram {
	//still in development..
	public static void main(String[] args) {
		/*
		 * 2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천
		 */
		StringBuffer buffer = new StringBuffer();
		String newId= ".Aa1@#!..bBj2_lflks..-djf;sdfk''js.";//아이디 예
		newId = newId.toLowerCase();//영어 대문자 소문자로 치환하기
		newId = newId.replaceAll("[^a-z|^0-9|^\\-|^_|^.]", "");//영어 소문자, 숫자, '-', '_', "."이 아니면 제거하기
		//'-'는 역슬래쉬를 두개 붙여준 점에 유의하기!!
		
		newId = newId.replace("..",".");//연속으로 존재하는 ..은 .으로 치환하기
		if(newId.charAt(0)=='.') {//맨 첫번째에 .이 있다면
			buffer.append(newId);
			buffer.deleteCharAt(0);
		}
		if(newId.charAt(newId.length()-1)=='.') {//맨 마지막에 .이 있다면
			buffer.deleteCharAt(buffer.length()-1);
		}
		if(buffer.length()==0) {//newId가 비어있다면, a를 붙여주어야 함
			buffer.append("a");
			
		}
		if(buffer.length()>=16) {//아이디의 길이가 16자를 넘는다면 15자 이후로는 다 잘라주기
			System.out.println(buffer.length());
			
			buffer.delete(15, buffer.length());
		}
		newId = buffer.toString();//지금까지 바뀐 버퍼값을 스트링으로 바꿔주기
		
		if(newId.charAt(newId.length()-1)=='.') {//맨 마지막에 .이 있다면
			buffer.deleteCharAt(buffer.length()-1);
			newId = buffer.toString();
		}
		if(newId.length()<=2) {//길이가 2보다 작으면 3이 될때까지 마지막 문자를 붙여준다.
			char lastChar = newId.charAt(newId.length()-1);//자료형 char로 받
			String lastCharStr = Character.toString(lastChar);//char to Stirng
			while(newId.length()<=3) {
				newId.concat(lastCharStr);
			}
		}
		
		System.out.println(newId);
		

	}

}
