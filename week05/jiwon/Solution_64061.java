package com.AlgoStudy.A1;

import java.util.*;

/*
 * 바구니 deque
 * if(peek==현재)
 * pop
 * 
 * moves를 돌면서 i번째 해당하는 열에 dive
 * -> 0아닌거 하나 꺼낸다 후 0으로 바꾼다-> break
 * */
public class Solution_64061 {
	 public int solution(int[][] board, int[] moves) {
		 int answer = 0;
		 Deque<Integer> basket = new ArrayDeque<>();
		 
		 for (int move : moves) {
			 int col = move - 1;
			 
			 for (int row = 0; row < board.length; row++) {
				if (board[row][col]!=0) {
					int doll = board[row][col];
					board[row][col]=0;
					
					if (!basket.isEmpty() && basket.peek()==doll) {
						basket.pop();
                        answer += 2;
					}
					else {
						basket.push(doll);
					}
					break;
				}
				
			}
		}
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution_64061 solver = new Solution_64061();
        
        // 예시 데이터 테스트
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        
        System.out.println(solver.solution(board, moves));

	}

}
