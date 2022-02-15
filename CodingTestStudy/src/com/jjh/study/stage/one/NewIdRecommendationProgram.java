package com.jjh.study.stage.one;

//신규아이디 추천
public class NewIdRecommendationProgram {
	
	public String solution(String newId) {
		//영어 대문자 소문자로 치환하기
		newId = newId.toLowerCase();
		//영어 소문자, 숫자, '-', '_', "."이 아니면 제거해주는 정규표현식.
		newId = newId.replaceAll("[^-_.a-z0-9]", "");
		newId = newId.replace("..",".");//연속으로 존재하는 ..은 .으로 치환하기
		//만약에 ...이 아이디에 포함되어 있었으면 치환 후에도 ..이라서 다시 치환이 필요하다.
		while(newId.contains("..")) {
			newId = newId.replace("..",".");
		}
		StringBuffer sb = new StringBuffer(newId);
		if(sb.charAt(0)=='.') {//맨 첫번째에 .이 있다면
			sb.deleteCharAt(0);
		}
		
		if(newId.charAt(newId.length()-1)=='.' && sb.length()!=0) {//맨 마지막에 .이 있다면
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(sb.length()==0) {//newId가 비어있다면, a를 붙여주어야 함
			sb.append("a");
		}
		if(sb.length()>=16) {//아이디의 길이가 16자를 넘는다면 15자 이후로는 다 잘라주기
			sb.delete(15, sb.length());
		}
		
		if(sb.charAt(sb.length()-1)=='.') {//맨 마지막에 .이 있다면
			sb.deleteCharAt(sb.length()-1);
		}
		if(sb.length()<=2) {//길이가 2보다 작으면 3이 될때까지 마지막 문자를 붙여준다.
			String lastCharStr = Character.toString(sb.charAt(sb.length()-1));
			while(sb.length() < 3) {
				sb.append(lastCharStr);
			}
		}
		return sb.toString();
		
	}
	

}
