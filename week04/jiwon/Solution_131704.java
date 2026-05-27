package com.AlgoStudy.A1;

import java.util.*;

/*
 * 보조 컨테이너 벨트: Stack
 * Stack에 작은 순서대로 쌓는다
 * */
public class Solution_131704 {
	 public int solution(int[] order) {
		 int answer = 0;
		 Deque<Integer> subBelt = new ArrayDeque<>();
		 int box = 1; // 1번 상자부터 시작
	     int idx = 0;
	     
	     while (idx < order.length) {
			if (box<=order[idx]) {
				subBelt.push(box++);
			}else if (!subBelt.isEmpty() && subBelt.peek() == order[idx]) {
                // 보조 벨트 맨 위 상자가 기사님 요구와 일치하면 트럭에 싣기
                subBelt.pop();
                idx++;
                answer++;
            } else {
                // 기존 벨트도 다 지나갔고, 보조 벨트 맨 위도 안 맞으면 더 이상 진행 불가
                break;
            }
		}
	        return answer;
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_131704 solver = new Solution_131704();

   
        int[] order1 = {4, 3, 1, 2, 5};
        int result1 = solver.solution(order1);
        System.out.println(result1);

        int[] order2 = {5, 4, 3, 2, 1};
        int result2 = solver.solution(order2);
        System.out.println(result2);

	}

}
