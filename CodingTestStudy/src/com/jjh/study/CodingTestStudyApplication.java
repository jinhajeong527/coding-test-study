package com.jjh.study;

import com.jjh.study.stage.one.IntPlacementByDescendingOrder;
import com.jjh.study.stage.one.SquareRootVerification;
import com.jjh.study.stage.one.SumOfDivisors;

public class CodingTestStudyApplication {

	public static void main(String[] args) {
		
		/* ���� ������ �Ǻ� */
		SquareRootVerification squareRootVerification = new SquareRootVerification();
		squareRootVerification.solution(144);
		/* ���� ������������ ��ġ�ϱ� */
		IntPlacementByDescendingOrder intPlacementByDescendingOrder = new IntPlacementByDescendingOrder();
		intPlacementByDescendingOrder.solution(1241412);
		/*����� �� */
		SumOfDivisors sumOfDivisors = new SumOfDivisors();
		sumOfDivisors.solution(10000);
	}
}
