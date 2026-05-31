package com.algo;

import java.util.Stack;

public class Solution_131704 {
	class Solution {
	    public int solution(int[] order) {
	    	Stack<Integer> st = new Stack<>();
	    	
	    	int idx =0;
	    	int result =0;
	    	
	    	for(int box =1; box<=order.length; box++) {
	    		if(box == order[idx]) {
	    			result++;
	    			idx++;
	    		}else {
	    			st.push(box);
	    		}
	    		
	    		while(!st.isEmpty() && st.peek() == order[idx]) {
		    		st.pop();
		    		result++;
		    		idx++;
		    	}
	    	}
	    	
	    	
	       
	        return result;
	    }
	}

}
