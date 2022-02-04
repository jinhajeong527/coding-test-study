package com.jjh.study;

import com.jjh.study.stage.one.*;

public class CodingTestStudyApplication {

	public static void main(String[] args) {

		/* 정수 제곱근 판별 */
		SquareRootVerification squareRootVerification = new SquareRootVerification();
		squareRootVerification.solution(144);
		/* 정수 내림차순으로 배치하기 */
		IntPlacementByDescendingOrder intPlacementByDescendingOrder = new IntPlacementByDescendingOrder();
		intPlacementByDescendingOrder.solution(12414);
		/*약수의 합 */
		SumOfDivisors sumOfDivisors = new SumOfDivisors();
		sumOfDivisors.solution(10000);
		
		PandYCount pandYCount = new PandYCount();
		pandYCount.solution("PYPYPYpypypoooo");

		/*문자열 다루기 기본*/
		HandlingStrings handlingStrings = new HandlingStrings();
		handlingStrings.solution("12312");

		/*행렬의 덧셈*/
		TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray();
		twoDimensionalArray.solution(new int[][]{{1,2},{2,3}}, new int[][]{{3,4},{5,6}});
		
	}
}
