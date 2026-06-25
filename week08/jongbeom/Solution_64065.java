package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_64065 {

	class Solution {
	    public int[] solution(String s) {
	        List<Integer> answer = new ArrayList<>();
	        s = s.substring(2, s.length() -2);
	        
	        String[] arr = s.split("\\},\\{");
	        
	        Arrays.sort(arr, (a,b) -> a.length() - b.length());
	    
	        
	        Set<Integer> set = new HashSet<>();
	        for(String str : arr) {
	        	String[] nums = str.split(",");
	        	
	        	for(String num : nums) {
	        		int n = Integer.parseInt(num);
	        		
	        		if(!set.contains(n)) {
	        			set.add(n);
	        			answer.add(n);
	        		}
	        	}
	        	
	        }

        	int[] result = new int[answer.size()];
        	for(int i=0; i<result.length; i++) {
        		result[i] = answer.get(i);
        	}
	        
	       
	        return result;
	    }
	}
}
