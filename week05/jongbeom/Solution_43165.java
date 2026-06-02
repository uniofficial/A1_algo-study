package com.algo;

public class Solution_43165 {
	class Solution {
    	int[] numbers;
    	int target;
    	int answer;
    	
    	
		
		public void dfs (int idx, int sum){
    		if(idx == numbers.length) {
    			if(sum == target) {
    				answer++;
    			}
    			return;
    		}
    		
    		dfs(idx +1, sum + numbers[idx]);
    		dfs(idx +1 , sum  - numbers[idx]);
		}
    		
	    public int solution(int[] numbers, int target) {
	    	this.numbers = numbers;
	    	this.target = target;
	    	this.answer = 0;
	    	
	        dfs(0,0);
	        return answer;
	    }
	}

}
