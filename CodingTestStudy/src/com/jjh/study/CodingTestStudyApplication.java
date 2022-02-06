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

		/*문자열 내림차순으로 배치하기*/
		StringRelocationByDescendingOrder stringRelocationByDescendingOrder = new StringRelocationByDescendingOrder();
		stringRelocationByDescendingOrder.solution("KkaA");

		/*시저 암호*/
		CaesarCipher caesarCipher = new CaesarCipher();
		caesarCipher.solution("ZML   A",25);

		/* 소수 찾기 */
		FindingDemimal findingDemimal = new FindingDemimal();
		findingDemimal.solution(5);

		/*문자열을 정수로 바꾸기 */
		StrngToInteger stringToInteger = new StrngToInteger();
		stringToInteger.solution("-1212");

		/*이상한 문자 만들기 */
		MakingWeirdWords makingWeirdWords = new MakingWeirdWords();
		makingWeirdWords.solution("try hello world");



		
	}
}
