package com.jjh.study.leet.easy;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		pn.isPalindrome(1);
	}
	public boolean isPalindrome(int x) {
		
		boolean isPalindrome = false;
		if(x < 0) return false;//음수일 경우에는 -가 숫자의 끝에 붙어서 false가 된다.
		if(x <= 9) return true;//한자리수의 양수일 경우 무조건 true가 된다. 
		
		String xStr = Integer.toString(x);
		
		int length = xStr.length();
		int index1 = 0;
		int index2 = length-1;
		while(xStr.charAt(index1)==xStr.charAt(index2)) { //맨 앞과 맨 끝의 인덱스 값을 비교한다.
			index1++;
			index2--;
			if(index1==length/2) { //비교 할필요가 없는 범위까지 index가 왔다는 것은 isPalindrome 하다는 뜻
				isPalindrome = true;
				break;
			}
		}
		
		return isPalindrome;   
    }

}
