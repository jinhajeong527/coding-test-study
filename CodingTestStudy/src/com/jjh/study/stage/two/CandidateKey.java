package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 프로그래머스 2단계 : 후보키
public class CandidateKey {
	public static void main(String[] args) {
		CandidateKey ck = new CandidateKey();
		ck.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
								   {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
	}
	List<String> candidates = new ArrayList<String>();
	public int solution(String[][] relation) {
		for(int i = 0; i < relation[0].length; i++) {
			boolean[] visited = new boolean[relation[0].length];
			dfs(visited, 0, 0, i+1, relation);
		}
		return candidates.size();
    }

	private void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
		if(depth == end) {
			List<Integer> seqList = new ArrayList<Integer>();
			String key = "";
			for(int i = 0; i < visited.length; i++) {
				if(visited[i])  {
					key += i;
					seqList.add(i);
				}
			}
			// 해당 키조합으로 동일한 컬럼 있는지 체크한다. 
			// 유일성 체크
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int i = 0; i < relation.length; i++) {
				String value = "";
				for(int j : seqList) {
					value += relation[i][j];
				}
				// 이미 존재하는 키면 리턴시켜버리기 때문에 후보키 체크(최소성의 체크)까지 넘어가지 않는다.
				if(map.containsKey(value)) return;
				else map.put(value, 0);
			}
			// 여기까지 왔다면 후보키 체크가 가능하다. 유일성을 만족하는 key만 여기서 체크가 될 것이다.
			for(String s : candidates) {
				int count = 0;
				for(int i = 0; i < key.length(); i++) {
					String subStr = String.valueOf(key.charAt(i));
					if(s.contains(subStr)) count++;
				}
				// 후보키에 등록된 String s와 일치하는 char를 센 개수가 s의 개수와 같다면 최소성을 만족하지 못하게 된다.
				if(count == s.length()) return;
			}
			// 후보키를 추가한다.
			candidates.add(key);
		}
		
		// "31"같은 조합은 필요없기 때문에 i = start 이다.
		for(int i = start; i < visited.length; i++) {
			if(visited[i]) continue;
			else visited[i] = true;
			dfs(visited, start, depth + 1, end, relation);
			visited[i] = false;
		}
	}

	
}
