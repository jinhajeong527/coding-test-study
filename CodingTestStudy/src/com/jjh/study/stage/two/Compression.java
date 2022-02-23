package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {

	public int[] solution(String msg) {
		int[] answer = {};
		Map<String, Integer> map = new HashMap<>(); // 사전을 담을 맵
		List<Integer> list = new ArrayList<>(); // msg 색인번호 담아서 리턴할 리스트
		String capAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] chars = capAlphabet.toCharArray();
		int length = chars.length;
		boolean isEnd = false;

		// 알파벳을 키로 사전 등록함.
		for (int i = 0; i < length; i++)
			map.put(String.valueOf(chars[i]), i + 1);

		for (int i = 0; i < msg.length(); i++) {
			String word = msg.charAt(i) + "";// String 형변환

			while (map.containsKey(word)) {// 사전에 단어가 있는 동안은
				i++;
				if (i == msg.length()) {
					isEnd = true;
					break;
				}
				word += msg.charAt(i);//다음 문자추가해서 사전에 있는지 확인한다.
			}
			if (isEnd) {
				list.add(map.get(word));
				break;
			}

			list.add(map.get(word.substring(0, word.length() - 1)));
			map.put(word, ++length); // 사전에 단어 추가
			i--; //단어를 찾아서 넣어준 시점에서 하나 뺴주어야 for문이 돌면서 1이 추가되어 적절한 위치부터 다시 단어 탐색할 것.
		}

		answer = list.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}

}
