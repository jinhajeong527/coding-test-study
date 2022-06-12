package com.jjh.study.stage.two.exhaustive;

import java.util.*;

// 프로그래머스 2단계 : 수식 최대화
public class MaximalUseOfMathematicalExpression {
    // ** 전역변수의 설정
    static long max = 0;
    // expression 문자열에서 숫자부분
    static List<Long> numberList = new ArrayList<>();
    // expression 문자열에서 수식 부분
    static List<Character> expressionList = new ArrayList<>();
    // 수식의 종류
    static List<Character> expressionKind = new ArrayList<>();
    // 가능한 연산자의 우선순위 구하기 위한 visited[]
    static boolean[] visited;

    public long solution(String expression) {

        splitNumbersAndExpressions(expression);
        visited = new boolean[expressionKind.size()];
        //우선 순위 담아줄 List order를 선언한다.
        List<Character> order = new ArrayList<>();
        makePossiblePriorities(order);
        return max;
    }
    // 주어진 연산자를 이용하여 모든 우선순위 경우의 술르 만들고, 해당 우선순위에 기반하여 결과값 계산하는 메서드 calculate 호출한다.
    private void makePossiblePriorities(List<Character> order) {
        if(order.size() == expressionKind.size()) { // 우선순위 연산자의 완성
            // 연산자 우선순위 정보 인자로 넣어서 계산 값 얻어오고, max 보다 큰 값일 경우 max 값 answer로 set 해준다.
            long answer = calculate(order);
            if(max < answer) max = answer;
            return;
        }

        for(int i = 0; i < expressionKind.size(); i++) {
            if(visited[i]) continue; // 이미 방문했다면 continue
            order.add(expressionKind.get(i));
            visited[i] = true; // 해당 인덱스의 연산자 방문한걸로 표시 후 재귀함수 호출
            makePossiblePriorities(order);
            visited[i] = false; // 재귀 함수 호출 했으니 다시 방문 안한 상태로 돌려준 후에 추가했던 연산자 삭제해준다.
            order.remove(order.size() - 1);
        }
    }

    private long calculate(List<Character> order) {
        List<Long> copyNumList = new ArrayList<>(numberList);
        List<Character> copyExpList = new ArrayList<>(expressionList);
        for(char orderChar : order) {
            for(int i = 0; i < copyExpList.size(); i++) {
                if(orderChar == copyExpList.get(i)) {
                    copyNumList.set(i, calculateOpt(copyNumList.get(i), copyNumList.get(i+1), orderChar));
                    copyNumList.remove(i+1);
                    copyExpList.remove(i);
                    i--;
                }
            }
        }
        return Math.abs(copyNumList.get(0));
    }

    private Long calculateOpt(Long a, Long b, char orderChar) {
        if(orderChar == '+') {
            return a + b;
        }
        else if(orderChar == '-') {
            return a - b;
        }
        else {
            return a * b;
        }
    }

    private void splitNumbersAndExpressions(String expression) {
        Set<Character> expressionSet = new HashSet<>();
        char[] expChars = expression.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < expChars.length; i++) {
            if(isExpression(expChars[i])) { // 수식일 경우
                expressionList.add(expChars[i]);
                expressionSet.add(expChars[i]);
                // 수식 나오면 그 전까지의 char가 숫자이므로 numberList에 추가해준다.
                numberList.add(Long.valueOf(sb.toString()));
                // 스트링 빌더 초기화 할 것
                sb = new StringBuilder();
            } else { // 숫자 부분일 경우
                sb.append(expChars[i]);
            }
        }
        // for문 종료 후 마지막 연산자 이후의 숫자도 추가해준다.
        numberList.add(Long.valueOf(sb.toString()));
        expressionKind = new ArrayList<>(expressionSet);
    }

    // *, +, - 연산자인지 확인하는 메서드
    private boolean isExpression(char expression) {
        if(expression == '*' || expression == '+' || expression == '-') return true;
        else return false;
    }
}
