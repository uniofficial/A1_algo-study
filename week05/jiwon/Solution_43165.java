package com.AlgoStudy.A1;
/*
 * 방법의 수 -> 경우의 수 -> DFS
 * 
 * if(cur==target)
 * answer++
 * 
 * +-를 하나씩 시도
 * */

public class Solution_43165 {

	static int answer = 0;
	public int solution(int[] numbers, int target) {
		answer = 0;
		dfs(0, 0, numbers, target);
	        return answer;
	    }
	public static void dfs(int result, int idx, int[] numbers, int target) {
		if(idx==numbers.length) {
			if (result == target) {
                answer++;
            }
            return;
		}
        // 1. 현재 숫자를 더하는 경우

		dfs(result + numbers[idx], idx + 1, numbers, target);            
            // 2. 현재 숫자를 빼는 경우
		dfs(result - numbers[idx], idx + 1, numbers, target);
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_43165 sol = new Solution_43165();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));

	}

}
