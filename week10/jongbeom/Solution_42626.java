package com.algo;

import java.util.PriorityQueue;

public class Solution_42626 {
	class Solution {
	    public int solution(int[] scoville, int K) {
	    	int answer = 0;
	    	PriorityQueue<Integer> pq = new PriorityQueue<>();
	    	
	    	for(int s : scoville) {
	    		pq.offer(s);
	    	}
	    	
	    	
	    	while(pq.peek() < K) {
	    		if(pq.size() < 2)
	    			return -1;
	    		
	    		int food1 = pq.poll();
	    		int food2 = pq.poll();
	    		
	    		pq.offer(food1 + food2 *2);
	    		answer++;
	    	}
	       
	        return answer;
	    }
	}
}
