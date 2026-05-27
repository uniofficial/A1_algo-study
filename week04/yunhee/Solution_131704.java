// 택배상자 

// 보조 컨테이너 후입선출 -> 스택
// 현재 메인 벨트 상자가 원하는 번호면 바로 적재
// 아니면 보조 벨트 스택에 넣고 보조 벨트 top이 원하는 번호면 꺼내기 

package com.Algo.week04;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_131704 {
    public int solution(int[] order) {

        // 보조 컨테이너 벨트 스택
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0; // 트럭에 실은 상자 개수
        int idx = 0;   // order 배열에서 현재 원하는 상자의 위치

        for (int box = 1; box <= order.length; box++) {
            // 현재 메인 벨트 상자 지금 실어야 하는 상자면 바로 적
            if (box == order[idx]) {
                count++;
                idx++;

                // 보조 벨트 맨 위 상자도 현재 원하는 상자면 계속 적재 
                while (!stack.isEmpty() && stack.peek() == order[idx]) {
                    stack.pop();
                    count++;
                    idx++;

                    // order 범위 벗어나면 종료
                    if (idx == order.length) {
                        break;
                    }
                }

            } else {
                // 지금 필요한 상자 아니면 보조 벨트 스택에 
                stack.push(box);
            }
        }
        return count;
    }
}