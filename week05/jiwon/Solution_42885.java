package com.AlgoStudy.A1;

import java.util.*;

/*
 * if(무게 초과) return
 * 최대한 적게-> greedy -> 2명씩
 * 무게가 초과되지 않고 남는게 최소가 되게
 * 40~240
 * ------오류
 * 실제 사람들의 무게 배열을 정렬-> 투포인터
 * */
public class Solution_42885 {
	 public int solution(int[] people, int limit) {
		 int answer = 0;
		// 1. 사람들을 무게순으로 오름차순 정렬
	        Arrays.sort(people);
	        
	        int left = 0;
	        int right = people.length - 1;
	        
	        // 두 포인터가 교차할 때까지 반복
	        while (left <= right) {
	            // 혼자 남은 경우 보트 한 대 추가하고 종료
	            if (left == right) {
	                answer++;
	                break;
	            }
	            
	            if (people[left] + people[right] <= limit) {
	                left++;  
	                right--;
	            } else {
	                // 두 명 합이 limit을 초과하면 무거운 사람은 어차피 누구랑도 같이 못 탑니다.
	                // 따라서 무거운 사람 혼자 보냅니다.
	                right--;
	            }
	            
	            answer++; // 어떤 경우든 보트는 한 대 출발합니다.
	        }
	        
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42885 solver = new Solution_42885();

        // 입출력 예 #1
        int[] people1 = {70, 50, 80, 50};
        int limit1 = 100;
        System.out.println(solver.solution(people1, limit1));

	}

}
