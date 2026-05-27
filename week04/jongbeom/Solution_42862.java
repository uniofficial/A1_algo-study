package com.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_42862 {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	    	Set<Integer> lostSet = new HashSet<>();
	    	Set<Integer> reserveSet = new HashSet<>();
	    	
	    	Arrays.sort(lost);
	    	for(int x : lost) {
	    		lostSet.add(x);
	    	}
	    	
	    	for(int y: reserve) {
	    		reserveSet.add(y);
	    	}
	    	
	    	Set<Integer> same = new HashSet<>(lostSet);
	    	
	    	for(int x : same) {
	    		if(reserveSet.contains(x)) {
	    			lostSet.remove(x);
	    			reserveSet.remove(x);
	    		}
	    	}
	    	
	    		
	    		for(int x : lost) {
	    			if(!lostSet.contains(x)) {
	    				continue;
	    			}
	    			
	    			if(reserveSet.contains(x-1)) {
	    				reserveSet.remove(x-1);
	    				lostSet.remove(x);
	    			}else if(reserveSet.contains(x+1)) {
	    				reserveSet.remove(x+1);
	    				lostSet.remove(x);
	    			}
	    		}
	    	
	    		
	        
	        return n - lostSet.size();
	    }
	}

}
