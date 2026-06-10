package com.algo;

public class Solution_17681 {
	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	    	String[] answer = new String[n];
	    	
	    	for(int i=0; i<n; i++) {
	    		int map = arr1[i] | arr2[i];
	    		String binary = Integer.toBinaryString(map);
	    		
	    		binary = String.format("%" + n + "s", binary).replace(' ', '0');
	    		
	    		StringBuilder row = new StringBuilder();
	    		for(int j=0; j<binary.length(); j++) {
	    			if(binary.charAt(j) == '1') {
	    				row.append("#");
	    			}else {
	    				row.append(" ");
	    			}
	    			answer[i] = row.toString();
	    		}
	    	}
	    	
	    	
	    	
	    	
	        
	        return answer;
	    }
	}

}
