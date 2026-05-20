package com.algo;
import java.util.*;

public class Solution_12973 {
	class Solution
	{
	    public int solution(String s)
	    {
	    	
	        Stack<Character> st = new Stack<>();
	        
	        for(int i=0; i<s.length(); i++) {
	        	char c = s.charAt(i);
	        	
	        	if(st.isEmpty()) {
	        		st.push(c);
	        	}else {
	        		if(st.peek() == c) {
	        			st.pop();
	        		}else {
	        			st.push(c);
	        		}
	        	}
	        }
	        int answer =0;
	        if(st.isEmpty()) {
	        	answer = 1;
	        }else {
	        	answer = 0;
	        }
	        
	        
	        

	        return answer;
	    }
	}
}
