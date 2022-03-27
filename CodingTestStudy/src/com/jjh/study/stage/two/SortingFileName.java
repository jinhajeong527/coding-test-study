package com.jjh.study.stage.two;

import java.util.Arrays;
import java.util.Comparator;

//파일명 정렬
public class SortingFileName {
	public static void main(String[] args) {
		SortingFileName sf = new SortingFileName();
		sf.solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
	}
	
	public String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		
        		String head1 = o1.split("[0-9]")[0];
        		String head2 = o2.split("[0-9]")[0];
        		
        		//o1 > o2 :양수, o1 < o2 : 음수, o1 = o2 : 0 리턴한다.
        		int result = head1.toLowerCase().compareTo(head2.toLowerCase());
        		
        		if(result == 0) { //head만 비교했을 때 같았다는 뜻이 되므로 숫자까지 비교해준다.
        			result = convertNum(o1, head1) - convertNum(o2, head2);
        		}
        		
        		return result;
        	}
		});
        
        return files;
    }

	public int convertNum(String o, String head) {
		
		o = o.substring(head.length());//head 길이만큼 잘라주면 앞의 문자열 부분 제거할 수 있다.
		
		for(int i = 0; i < o.length(); i++) {
			if(!Character.isDigit(o.charAt(i))) { //숫자가 아닐 때 인덱스 값 얻어와 숫자인 부분까지 자른 후에 int로 바꿔준다.
				o = o.substring(0, i);
			}
		}
		int converted = Integer.parseInt(o);
		return converted;
	}
}
