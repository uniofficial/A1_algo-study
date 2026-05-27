package com.algo;
import java.util.*;

public class Solution_42883 {
	class Solution {
	    public String solution(String number, int k) {
	    	
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i=0; i<number.length(); i++) {
	        	int digit = number.charAt(i) - '0';
	        	
	        	while(!st.isEmpty() && k > 0 && st.peek() < digit) {
	        		st.pop();
	        		k--;
	        	}
	        	st.push(digit);
	        	
	        	
	        }
	        
	        while(k > 0) {
	            st.pop();
	            k--;
	        }
	        
	    
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<st.size(); i++) {
	        	
	        	sb.append(st.get(i));
	        	
	        }
	        return sb.toString();
	       
	    
	}

}
}
