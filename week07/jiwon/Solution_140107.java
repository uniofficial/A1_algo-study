package com.AlgoStudy.A1;
/*
 * 원점과 점의 거리
 * 
 * dist=sqrt((a*k)^2+(b*k)^2)
 * ----시간초과
 * y<=sqrt(d^2-(a*k)^2)
 * k를 늘려가며 최대 y값일때 k개수 구한다
 * 
 * */
public class Solution_140107 {
	 public long solution(int k, int d) {
	        long answer = 0;
	        long dist = d;
	        //x는 a*k므로 k간격으로 커진다
	        for (long x = 0; x <= dist; x+=k) {
				long maxY = (long) Math.sqrt(dist*dist-x*x);
				//k의 배수
				answer +=(maxY/k)+1;
			}
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_140107 sol = new Solution_140107();
        System.out.println(sol.solution(2, 4));

	}

}
