package com.jjh.study.leet.easy;

public class NumberOfValidWordsInASentence {
	public static void main(String[] args) {
		NumberOfValidWordsInASentence novw = new NumberOfValidWordsInASentence();
		System.out.println(novw.countValidWords(" o6 t"));
	}
	public int countValidWords(String sentence) {
		int count = 0;
		String[] split = sentence.split("\\s+");
		
		for(int i = 0; i < split.length; i++) {
			// " o6 t" 같은 경우 첫번째 조건에 걸린다.
			if(split[i].isEmpty()||split[i].matches(".*[0-9].*") || split[i].startsWith("-") || split[i].endsWith("-")) {
				continue;
			} 
			if(split[i].startsWith("!") || split[i].startsWith(".") || split[i].startsWith(",")) {
				if(split[i].length() == 1) { // 예시 - "!", ".", ","
					count++;
				}
				continue;
			}
			int hyphenCount = 0;
			boolean isWeirdPosition = false;
			for(int j = 0; j < split[i].length(); j++) {
				
				if((split[i].charAt(j) == '!'|| split[i].charAt(j) == ','|| split[i].charAt(j) == '.' ) && j != split[i].length() - 1) {
					isWeirdPosition = true;
					break;
				}
				if((split[i].charAt(j) == '-')) {
					if(!Character.isLetter(split[i].charAt(j-1)) || !Character.isLetter(split[i].charAt(j+1))) {
						isWeirdPosition = true;
						break;
					} else if(Character.isLetter(split[i].charAt(j-1)) && Character.isLetter(split[i].charAt(j+1))) {
						if(hyphenCount > 1) { 
							break;
						} else {
							hyphenCount++;
						}
					}
				}
				
			}
			// "a-b-c" 같은 경우를 위해 hyphenCount가 1이하 하는 조건 넣음.
			if(hyphenCount <= 1 && !isWeirdPosition) {
				count++;
			}
			
		}
        return count;
    }
}
