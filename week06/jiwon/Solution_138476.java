package com.AlgoStudy.A1;

import java.util.*;

/*
 * 
 * 중복 개수를 센다
 * 내림차순 정렬 후 k개 만큼 선택
 * */
public class Solution_138476 {
	 public int solution(int k, int[] tangerine) {
	        int answer = 0;
	        Map<Integer, Integer> sizeMap = new HashMap<>();
	        
	        for (int size : tangerine) {
				sizeMap.put(size, sizeMap.getOrDefault(size, 0)+1);
			}
	        //귤의 개수만 list에 
	        List<Integer> gullist = new ArrayList<>(sizeMap.values());
	        
	        Collections.sort(gullist, Collections.reverseOrder());
	        
	        for (int gull: gullist) {
				k-=gull;
				answer++;
				if (k <= 0) { // k개를 다 채웠다면 종료
	                break;
	            }
			}
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_138476 sol = new Solution_138476();
        
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(sol.solution(k, tangerine));

	}

}
