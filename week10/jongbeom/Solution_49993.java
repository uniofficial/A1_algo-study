package com.algo;

public class Solution_49993 {
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	    	int result = 0;
	        for(int i=0; i<skill_trees.length; i++) {
	        	StringBuilder sb = new StringBuilder();
	        	String tree = skill_trees[i];
	        	
	        	for(int c=0; c<tree.length(); c++) {
	        		char ch = tree.charAt(c);
	        		
	        		
	        		if(skill.indexOf(ch) != -1) {
	        			sb.append(ch);
	        			
	        		}
	        	}
	        	
	        	if(skill.startsWith(sb.toString())){
	        		result++;
	        	}
	        
	        }
	    	
	        return result;
	    }
	}
}
