package com.jjh.study.stage.two;

//피보나치 수
public class FibonacciNumbers {
	public static void main(String[] args) {
		FibonacciNumbers fn = new FibonacciNumbers();
		fn.solution(3);
	}
	
	public int solution(int n) {
        int[] numbers = new int[n+1]; //n이 3일 경우에  0 1 2 3 총 4개의 공간이 필요하다.
        numbers = getFibonacciNumbers(numbers);
       
        return numbers[n];
    }
	
	public int[] getFibonacciNumbers(int[] numbers) {
		numbers[0] = 0;
		numbers[1] = 1;
		for(int i=2; i < numbers.length; i++) {
			int sum = numbers[i-1] + numbers[i-2];
			numbers[i] = sum % 1234567;//int 자료형의 범위내에서 항상 있을 수 있도록 나눠준다. (A + B) % C = ((A % C) + (B % C)) % C 
		}
		
		return numbers;
		
	}

}
