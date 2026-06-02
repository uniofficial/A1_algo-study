package com.algo;

import java.util.*;

public class Solution_155652 {
	class Solution {
	    public String solution(String s, String skip, int index) {
	    	StringBuilder sb = new StringBuilder();
	    	for(int i=0; i<s.length(); i++) {
	    		char alpha = s.charAt(i);
	    		
	    		int cnt = 0;
	    		while(cnt < index) {
	    			alpha ++;
	    			if(alpha > 'z') {
	    				alpha = 'a';
	    			}
	    			
	    			if(skip.indexOf(alpha) == -1) {
	    				cnt++;
	    			}
	    	
	    		}
	    		
	    		
	    		sb.append(alpha);
	    	}
	        return sb.toString();
	    }
	}
}
