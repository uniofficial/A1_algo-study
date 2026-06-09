package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_138476 {
	class Solution {
	    public int solution(int k, int[] tangerine) {
	       
	    	Arrays.sort(tangerine);
	    	ArrayList<Integer> arr = new ArrayList<>();
	    	int count = 1;
	    	
	    	for(int i=1; i<tangerine.length; i++) {
	    		if(tangerine[i] == tangerine[i-1]) {
	    			count++;
	    		}else {
	    			arr.add(count);
	    			count = 1;
	    		}
	    		
	    	}
	    	arr.add(count);
	    	
	    	int kind = 0;
	    	
	    	Collections.sort(arr,Collections.reverseOrder());
	    	
	    	for(int a : arr) {
	    		k -= a;
	    		kind++;
	    		
	    		if(k <=0 ) {
	    			break;
	    		}
	    	}
	    	
	        return kind;
	    }
	}
}
