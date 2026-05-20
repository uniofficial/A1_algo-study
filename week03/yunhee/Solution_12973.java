// 짝지어 제거하기 

package com.Algo.week03;

import java.util.Stack;

class Solution_12973 {
    public int solution(String s) {

        // 문자의 짝 관리할 스택 
        Stack<Character> stack = new Stack<>();

        // 문자열 순회
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i); // 현재 문자

            /*
             * 스택이 비어있지 않고
             * 스택 맨 위 문자와 현재 문자가 같다면
             * 짝이 완성된 것이므로 pop 해줌 
             */
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
            }

            // 짝 아니면 현재 문자 스택에 저장 
            else {
                stack.push(current);
            }
        }

        if (stack.isEmpty()) {
            return 1;	// 모든 문자 제거됐으면 성공 -> 1
        } else {	// 스택에 남아있으면 실패 -> 0 
            return 0;
        }
    }
}