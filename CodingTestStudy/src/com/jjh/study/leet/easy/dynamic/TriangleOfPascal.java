package com.jjh.study.leet.easy.dynamic;

import java.util.ArrayList;
import java.util.List;

public class TriangleOfPascal {
	public static void main(String[] args) {
		TriangleOfPascal tp = new TriangleOfPascal();
		tp.generate(5);
	}
	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> answerList = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) { //맨 처음 혹은 맨 마지막 인덱스는 1로 채워준다.
					list.add(1);
				} else {
					list.add(answerList.get(i-1).get(j-1)+answerList.get(i-1).get(j));
				}
			}
			answerList.add(list);
		}
        return answerList;
    }

}
