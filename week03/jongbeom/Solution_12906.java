package com.algo;

import java.util.*;

public class Solution_12906 {
    public int[] solution(int []arr) {
        
        
        ArrayList<Integer> list = new ArrayList<>();
        int start = arr[0];
        list.add(start);
        
        for(int i=1; i<arr.length; i++) {
        	if(arr[i] != start) {
        		list.add(arr[i]);
        		start = arr[i];
        	}else {
        		continue;
        	}
        	
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}