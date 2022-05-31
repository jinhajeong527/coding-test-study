package com.jjh.study.leet.easy.greedy;

//리트코드 : 1736. Latest Time by Replacing Hidden Digits
public class LatestTimeByReplacingHiddenDigits {
	public static void main(String[] args) {
		LatestTimeByReplacingHiddenDigits ln = new LatestTimeByReplacingHiddenDigits();
		ln.maximumTime("?4:03");
	}
	public String maximumTime(String time) {
		
		StringBuffer sb = new StringBuffer(time);
		
		if(sb.charAt(0) == '?') {
			if(sb.charAt(1) == '?' || sb.charAt(1) <= '3') sb.setCharAt(0, '2');
			else sb.setCharAt(0, '1');
		}
		if(sb.charAt(1) == '?') {
			if(sb.charAt(0) == '2') sb.setCharAt(1, '3');
			else sb.setCharAt(1, '9');
		}
		if(sb.charAt(3) == '?') sb.setCharAt(3, '5');
		if(sb.charAt(4) == '?') sb.setCharAt(4, '9');
		return sb.toString();    
    }

}
