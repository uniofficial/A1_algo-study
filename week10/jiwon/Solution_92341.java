package com.AlgoStudy.A1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * records.split(" ")
 * Map
 * 
 * 
 * */
public class Solution_92341 {
	 public int[] solution(int[] fees, String[] records) {
		 Map<String, Integer> inTimeMap = new HashMap<>();
		 Map<String, Integer> totalTimeMap = new TreeMap<>();
		 int baseTime = fees[0];
	     int baseFee = fees[1];
	     int unitTime = fees[2];
	     int unitFee = fees[3];
	     
	     for (String record : records) {
			
	    	 String[] splitRecord = record.split(" ");
	    	 
	    	 String time = splitRecord[0];
	    	 String carNumber = splitRecord[1]; // "5961"
	         String INOUT = splitRecord[2];
	         
	         //분 단위로 바꿔야함
	         String[] timeSplit = time.split(":");
	         int timeInMinutes = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
	         
	         if (INOUT.equals("IN")) {
	        	 inTimeMap.put(carNumber, timeInMinutes);
			}else {
				int inTime = inTimeMap.remove(carNumber); // 꺼내면서 동시에 맵에서 삭제
                int parkedTime = timeInMinutes - inTime;
                
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
			}
		}
	  // 3. 출차 기록이 없는 차량 처리 (23:59 출차 간주)
	        int lastTimeOfValue = 23 * 60 + 59; 
	        for (String carNumber : inTimeMap.keySet()) {
	            int inTime = inTimeMap.get(carNumber);
	            int parkedTime = lastTimeOfValue - inTime;
	            
	            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
	        }
	        
	        int[] answer = new int[totalTimeMap.size()];
	        int idx = 0;

	        for (String carNumber : totalTimeMap.keySet()) {
	            int totalTime = totalTimeMap.get(carNumber);
	            int fee = baseFee; // 기본 요금 시작

	       
	            if (totalTime > baseTime) {
	                int extraTime = totalTime - baseTime;
	              
	                fee += (int) Math.ceil((double) extraTime / unitTime) * unitFee;
	            }
	            
	            answer[idx++] = fee;
	        }

	        return answer;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_92341 sol = new Solution_92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
            "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
            "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
            "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        
        int[] result = sol.solution(fees, records);
        for(int r : result) {
            System.out.println(r); 
        }
	}

}
