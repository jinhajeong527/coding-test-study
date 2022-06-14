package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {
	public static void main(String[] args) {
		OpenChattingRoom ocr = new OpenChattingRoom();
		ocr.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
	}
	public String[] solution(String[] record) {
		Map<String, String> idAndNicknameMap = new HashMap<String, String>();
		List<String[]> list = new ArrayList<String[]>();
		
		// 아이디를 key, 별명을 value로 한 맵을 만들어준다.
		for(int i = 0; i < record.length; i++) {
			String infos[] = record[i].split(" ");
			list.add(infos);
			if(infos[0].equals("Enter") || infos[0].equals("Change")) 
				idAndNicknameMap.put(infos[1], infos[2]);
		}
		List<String> answerList = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			String infos[] = list.get(i);
			if(infos[0].equals("Enter")) {
				answerList.add(idAndNicknameMap.get(infos[1])+"님이 들어왔습니다.");
			} else if(infos[0].equals("Leave")) {
				answerList.add(idAndNicknameMap.get(infos[1])+"님이 나갔습니다.");
			}
		}
        
        return answerList.toArray(new String[answerList.size()]);
    }

}
