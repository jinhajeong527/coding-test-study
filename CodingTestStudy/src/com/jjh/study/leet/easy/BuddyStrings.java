package com.jjh.study.leet.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {
	public boolean buddyStrings(String s, String goal) {
		
		// s와 goal의 길이가 같지 않으면 swqp을 통해 같은 값을 가질 수 없으므로 false를 리턴한다.
		if(s.length() != goal.length()) 
			return false;
		
		if(s.equals(goal)) { // abab 같은 경우는 true를 리턴할 것, abcd 같은 경우는 false를 리턴할 것
			Set<Character> set = new HashSet<>();
			for(char ch : s.toCharArray()) set.add(ch);
			return set.size() < s.length();
		}
		List<Integer> diff = new ArrayList<Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != goal.charAt(i)) diff.add(i);
		}
		
        return diff.size() == 2 && s.charAt(diff.get(0))==goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }

}
