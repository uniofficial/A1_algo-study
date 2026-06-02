package com.AlgoStudy.A1;
/*
 * K칸 점프 ->K칸 소모
 * (현재까지 온 거리) x 2 
 * 
 * 점프를 최소 -> greedy
 * 
 * (n-현재 위치)가 N보다 작은 최대 짝수가 되게
 * n홀수: n= (n-1)/2 -> ans++
 * n짝수: n/2 순간이동만 하므로 비용 없다
 * */
public class Solution_12980 {
	 public int solution(int n) {
	        int ans = 0;
	        
	        while (n>0) {
				if (n%2!=0) {
					n= (n-1)/2;
					ans++;
				}
				else {
					n=n/2;
				}
			}


	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_12980 sol = new Solution_12980();
        System.out.println(sol.solution(5));  
        System.out.println(sol.solution(6));

	}

}
