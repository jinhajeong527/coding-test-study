package com.jjh.study.leet.easy;

public class LengthOfLastWord {
	public static void main(String[] args) {
		LengthOfLastWord lolw = new LengthOfLastWord();
		lolw.lengthOfLastWord("   fly me   to   the moon   ");
	}
	public int lengthOfLastWord(String s) {
		String[] arr = s.split("\\s");
		for(int i = arr.length -1 ; i >= 0; i--) {
			if(arr[i].contains(" ")) continue;
			return arr[i].length();
		}
		return 0;
    }
}
