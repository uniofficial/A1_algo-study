package com.algo;

import java.util.*;

public class Solution_42889 {
	class Solution {
	    public int[] solution(int N, int[] stages) {
	        Arrays.sort(stages);
	        
	        int user =stages.length;
	        
	        double fail = 0;
	        int idx =0;
	        
	        double[] result = new double[N+1];
	        
	        for(int i=1; i<=N; i++) {
	        	int count = 0;
	        	while(idx < stages.length && stages[idx] == i) {
	        		idx ++;
	        		count ++;
	        	}
	        	if(user == 0) result[i] = 0;
	        	else result[i] = (double) count/ user;
	        	
	        	user -= count;
	        }
	        Integer[] stageNums = new Integer[N];
	        for(int i=0; i<N; i++) {
	        	stageNums[i] = i+1;
	        }
	        
	        Arrays.sort(stageNums, (a,b) ->{
	        	if(result[a] == result[b]) return a-b;
	        	return Double.compare(result[b], result[a]);
	        });
	        
	        int[] answer = new int[N];
	        for(int i=0; i<N; i++) {
	        	answer[i] = stageNums[i];
	        }
	        
	        	
	        
	        
	        return answer;
	    }
	}

}
