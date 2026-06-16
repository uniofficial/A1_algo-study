package com.AlgoStudy.A1;
/*
 * 누적 -> DP
 * 
 * max 선택+
 * 이전열 제외하고 max 선택
 * 
 * */
public class Solution_12913 {
	
	 int solution(int[][] land) {
	        int answer = 0;

	        int n = land.length;
	        
	        for (int i = 1; i < n; i++) {
	        	int a = land[i-1][0];
	            int b = land[i-1][1];
	            int c = land[i-1][2];
	            int d = land[i-1][3];
	            
	            land[i][0] += Math.max(b, Math.max(c, d)); // 0번 열은 1,2,3번 중 최고점 누적
	            land[i][1] += Math.max(a, Math.max(c, d)); 
	            land[i][2] += Math.max(a, Math.max(b, d)); 
	            land[i][3] += Math.max(a, Math.max(b, c));
	        	
	            for (int j = 0; j < 4; j++) {
	                answer = Math.max(answer, land[n-1][j]);
	            }
			}

	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_12913 solver = new Solution_12913();
		int[][] testLand = {
			{1, 2, 3, 5},
			{5, 6, 7, 8},
			{4, 3, 2, 1}
		};
		System.out.println(solver.solution(testLand));

	}

}
