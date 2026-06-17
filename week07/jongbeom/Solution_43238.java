package com.algo;

public class Solution_43238 {
	
	class Solution {
	    public long solution(int n, int[] times) {
	        long answer = 0;
	        
	        int max = times[0];
	        for(int num: times) {
	        	if(num > max) {
	        		max = num;
	        	}
	        }
	        
	        long left = 1;
	        long right = (long)max * n;
	        
	        while(left <= right) {
	        	long mid = (left + right) /2;
	        	long people = 0;
	        	
	        	for(int t : times) {
	        		people += mid/t;
	        		if(people >= n) break;
	        		
	        	}
	        	if(people >= n) {
        			right = mid -1;
        		}else {
        			left = mid +1;
        		}
	        	
	        }
	        return left;
	    }
	}

}
