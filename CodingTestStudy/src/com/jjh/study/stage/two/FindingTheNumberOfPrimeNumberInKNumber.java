package com.jjh.study.stage.two;

// K진수에서 소수 개수 구하기
public class FindingTheNumberOfPrimeNumberInKNumber {
    public static void main(String[] args) {
        FindingTheNumberOfPrimeNumberInKNumber fn = new FindingTheNumberOfPrimeNumberInKNumber();
        fn.solution(110011, 10);
        //fn.solution(437674,3);
    }
    public int solution(int n, int k) {
        int answer = 0;
        String decimalToKNumber = makeDecimalNumberToKNumber(n, k);
        String[] arrStr = decimalToKNumber.split("0");
        for(String str : arrStr) {
            if(str.equals("")) continue; // 00이 연속적으로 나오는 경우
            if(isPrimeNumber(str)) answer++;
        }
        return answer;
    }
    // 소수 판별
    private boolean isPrimeNumber(String strNum) {
        // ** int 형으로 할시에 소수로 나눠주어 붙여준 길이가 int 정수 범위를 초과할 수 있어서 long 형으로 받아주었다.
        long number = Long.parseLong(strNum);
        if(number == 0) return false;
        if(number == 1) return false;

        for(int i = 2; i <= Math.sqrt((double)number); i++) {
            // 나눠지면 소수가 아니니까 return false;
            if(number % i == 0) return false;
        }
        return true;
    }

    // 10진수 n을 k진수로 바꾼 String 값 리턴해주는 메서드
    public String makeDecimalNumberToKNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while(true) {
            int remainder = n % k;
            sb.append(remainder);
            n = n / k;
            if(n == 0) break;
        }
        String decimalToKNumber  = sb.reverse().toString();
        return decimalToKNumber;
    }
}
