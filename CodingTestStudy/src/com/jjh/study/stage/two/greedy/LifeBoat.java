package com.jjh.study.stage.two.greedy;

import java.util.Arrays;

//구명보트
public class LifeBoat {
	public static void main(String[] args) {
		LifeBoat lj = new LifeBoat();
		lj.solution(new int[] { 70, 50, 80, 50 }, 100);
	}

	public int solution(int[] people, int limit) {

		int answer = 0;
		Arrays.sort(people);
		int max = people.length - 1;
		int min = 0;
		for (int i = max; i >= min; i--) {

			int person = people[i];
			if (person + people[min] <= limit) min++;
			answer++;

		}

		return answer;

	}

}
