package com.algo;

public class Solution_140107 {
	class Solution {
	    public long solution(int k, int d) {
	    	
	    	long answer = 0;
	    	
	    	for(int i=0; i<=d; i+=k) {
	    		long maxy = (long)Math.sqrt((long)d*d - (long)i*i);
	    		answer +=(maxy/k)+1;
	    	}
	        
	        return answer;
	    }
	}

}
