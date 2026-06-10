package com.algo;

import java.util.HashSet;

public class Solution_12981 {
	class Solution {
	    public int[] solution(int n, String[] words) {
	    	
	    	HashSet<String> hs = new HashSet<>();
	    	String prev = words[0];
	    	hs.add(prev);
	    	
	    	for(int i=1; i<words.length; i++) {
	    		String cur = words[i];
	    		
	    		if(hs.contains(cur) ||
	    			prev.charAt(prev.length() -1) != cur.charAt(0) ||
	    			cur.length() == 1) {
	    			return new int[] {(i%n) +1, (i/n) +1};
	    		}
	    		
	    		hs.add(cur);
	    		prev = cur;
	    	}

	       
	        return new int[] {0,0};
	    }
	}
}
