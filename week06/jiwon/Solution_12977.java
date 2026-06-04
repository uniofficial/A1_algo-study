package com.AlgoStudy.A1;

import java.util.Arrays;

/*
 * 소수:	제곱근 까지 나누어 떨어지는지 아닌지
 * 경우의 수: 조합 dfs
 * */
public class Solution_12977 {
	static int[] result;
	static int answer = 0;
	 public int solution(int[] nums) {
	        answer = 0;
	        result = new int[3];
	        comb(0, 0, nums);
	        return answer;
	    }
	 static void comb(int cnt, int start, int[] nums) {
		 if(cnt==3) {
			 int sum = result[0] + result[1] + result[2]; // 뽑은 3개 숫자의 합
	            
	            if (isPrime(sum)) { // 그 합이 소수라면 결과 증가
	                answer++;
	            }
	            return;
		 }
		 for (int i = start; i < nums.length; i++) {
			 result[cnt] = nums[i];
			 comb(cnt + 1, i + 1, nums);
		}
	 }
	 
	 static boolean isPrime(int n) {
		if(n<2)return false;
		 for (int i = 2; i *i<= n; i++) {
			 if (n % i == 0) {
	                return false; // 하나라도 나누어 떨어지면 소수가 아님
	            }
		}
		 return true;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution_12977 sol = new Solution_12977();
		
		// 테스트 케이스 1
		int[] nums1 = {1, 2, 3, 4};
		System.out.println( sol.solution(nums1)); 
		System.out.println();

		// 테스트 케이스 2
		int[] nums2 = {1, 2, 7, 6, 4};
		System.out.println(sol.solution(nums2));

	}

}
