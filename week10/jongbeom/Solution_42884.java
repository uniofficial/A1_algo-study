package com.algo;

import java.util.Arrays;

public class Solution_42884 {
	class Solution {
	    public int solution(int[][] routes) {
	        Arrays.sort(routes, (o1,o2) -> o1[1] - o2[1]);
	        int camera = routes[0][1];
	        int count = 1;
	        
	        for(int i=0; i<routes.length; i++) {
	        	if(camera < routes[i][0]) {
	        		camera = routes[i][1];
	        		count++;
	        	}
	        }
	        return count;
	    }
	}
}
