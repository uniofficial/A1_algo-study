package com.algo;

import java.util.Stack;

public class Solution_64061 {

	class Solution {
	    public int solution(int[][] board, int[] moves) {
	    	
	    	Stack<Integer> st = new Stack<>();
	    	int answer =0;
	        
	    	for(int i=0; i<moves.length; i++) {
	    		int num = moves[i];
	    		
	    		for(int j=0; j<board.length; j++) {
	    			if(board[j][num-1] >0) {
	    				int doll = board[j][num-1];
	    				board[j][num-1] = 0;
	    				
	    				if(!st.isEmpty() && st.peek() == doll) {
	    					st.pop();
	    					answer += 2;
	    				}else {
	    					st.push(doll);
	    				}
	    				
	    				if(doll != 0) break;
	    			}
	    		}
	    	}
	        return answer;
	    }
	}
}
