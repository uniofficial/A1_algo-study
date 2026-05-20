package com.AlgoStudy.A1;

import java.util.ArrayList;
import java.util.*;

/*앞이랑 다를 때만 추가*/
public class Solution_12906 {
	public int[] solution(int []arr) {
        
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i]!=arr[i-1]) {
				 list.add(arr[i]);
			}
		}
		int[] answer = new int[list.size()];
		 for(int i = 0 ; i < answer.length; i++){
	            answer[i] = list.get(i);
	        }

	        return answer;        
        

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_12906 s = new Solution_12906();
		System.out.println(Arrays.toString(s.solution(new int[] {1,1,3,3,0,1,1})));

	}

}
