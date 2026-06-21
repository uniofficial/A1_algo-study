package com.algo;

public class Solution_12951 {

	class Solution {
	    public String solution(String s) {
	    	
	    	boolean isFirst = true;
	    	StringBuilder sb = new StringBuilder();
	    	
	    	for(int i=0; i<s.length(); i++) {
	    		char c = s.charAt(i);
	    		if(c == ' ') {
	    			sb.append(" ");
	    			isFirst = true;
	    			continue;
	    		}
	    		
	    		if(isFirst) {
	    			sb.append(Character.toUpperCase(c));
	    			isFirst = false;
	    		}else {
	    			
	    			sb.append(Character.toLowerCase(c));
	    		}
	    	}
	      
	        return sb.toString();
	    }
	}
}
