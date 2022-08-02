package com.jjh.study.leet.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckingIfOneStringSwapCanMakeStringsEqual {
	public boolean areAlmostEqual(String s1, String s2) {
		if(s1.equals(s2)) {
			Set<Character> set = new HashSet<Character>();
			for(char ch : s1.toCharArray()) set.add(ch);
			// 한번도 바꾸지 않아도 되는 경우도 포함하기 때문에 <= 
			return set.size() <= s1.length();
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i =  0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) list.add(i);
			if(list.size() > 2) return false;
		}
        return list.size() == 2 && s1.charAt(list.get(0)) == s2.charAt(list.get(1)) && s1.charAt(list.get(1)) == s2.charAt(list.get(0));
    }
}
