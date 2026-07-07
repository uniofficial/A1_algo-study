package com.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution_92341 {

	class Solution {
	    public int[] solution(int[] fees, String[] records) {
	    	
	    	Map<String, Integer> totalTime = new TreeMap<>();
	    	Map<String, Integer> inTime = new HashMap<>();
        	
	        for(String record : records) {
	        	String[] temp = record.split(" ");
	        	
	        	if(temp[2].equals("IN")) {
	        		String[] time = temp[0].split(":");
	        		int minute = Integer.parseInt(time[0]) * 60
	        					 + Integer.parseInt(time[1]);
	        		
	        		inTime.put(temp[1] ,minute);
	        	
	        	}else {
	        		String[] outtime = temp[0].split(":");
	        		int outminute = Integer.parseInt(outtime[0]) * 60
       					 			+ Integer.parseInt(outtime[1]);
	        		int lasttime = inTime.get(temp[1]);
	        		
	        		int parkingtime = outminute-lasttime;
	        		
	        		
	        		
	        		totalTime.put(temp[1], totalTime.getOrDefault(temp[1], 0) + parkingtime);
	        		
	        		inTime.remove(temp[1]);
	        	}
	        	
	        }
	        
	        for(Map.Entry<String, Integer> entry : inTime.entrySet()) {
	        	int parkingtime2 = (23*60 +59) - entry.getValue();
	        	totalTime.put(
	        		    entry.getKey(),
	        		    totalTime.getOrDefault(entry.getKey(), 0) + parkingtime2
	        		);
	        }
	        
	       int[] answer = new int[totalTime.size()];
	       int idx = 0;
	       
	       for (Map.Entry<String, Integer> entry : totalTime.entrySet()) {
	    	   int total = entry.getValue();
               if (total <= fees[0]) {
                   answer[idx++] = fees[1];
               } else {
                   int over = total - fees[0];
                   int fee = fees[1]
                           + (int) Math.ceil((double) over / fees[2]) * fees[3];
                   answer[idx++] = fee;
               }

           }

           return answer;
	       
	       }
	    
	}
}

