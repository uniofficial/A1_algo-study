package com.algo;

public class Solution_12977 {

	class Solution {
		 int answer;
		 int[] nums;
		
		public void dfs(int depth , int start,int sum){
			if(depth == 3) {
				if(isPrime(sum)) {
					answer++;
				}
				return;
			}
			
			for(int i=start; i<nums.length; i++) {
				dfs(depth +1, i +1, sum + nums[i]);
			}
			
    	}
		
		public boolean isPrime(int sum) {
			if(sum <=1) return false;
			
			for(int i=2; i<sum; i++) {
				if(sum % i == 0) {
					return false;
				}
			}
			return true;
		}
		
	    public int solution(int[] nums) {
	    	answer = 0;
	    	this.nums = nums;
	    	dfs(0,0,0);
	       
	        return answer;
	    }
	}
}
