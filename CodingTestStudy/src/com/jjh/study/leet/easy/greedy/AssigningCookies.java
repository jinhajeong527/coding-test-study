package com.jjh.study.leet.easy.greedy;

import java.util.Arrays;

// 리트코드: Assign Cookies, Greedy, Easy
public class AssigningCookies {
	public static void main(String[] args) {
		//g = [1,2,3], s = [1,1]
		AssigningCookies ac = new AssigningCookies();
		ac.findContentChildren(new int[] {1,2,3}, new int[] {1,1});
	}
	
	public int findContentChildren(int[] g, int[] s) {
		
		// 아이들이 만족하는 쿠키 사이즈 정보 담긴 배열 g 오름차순 정렬
		Arrays.sort(g);
		int childCount = g.length;
		int i = 0;
		int count = 0;
		// 쿠키의 사이즈가 담긴 배열 s 오름차순 정렬
		Arrays.sort(s);
		
		for(int j = 0; j < s.length; j++) {
			// s[j]가 g[i]를 만족시키는 경우
			if(s[j] >= g[i]) {
				count++;//만족시킨 child 수 증가시키기
				i++;//greed factor 인덱스 증가시키기
				if(i == childCount) break;
			}
		}
		
		return count;
	}
}
