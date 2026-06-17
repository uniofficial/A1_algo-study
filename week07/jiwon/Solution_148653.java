package com.AlgoStudy.A1;
/*
 * 최소의 개수 -> greedy
 * 
 * 가능한 조합 중에서 연산이 최소
 * 
 * 10^n을 +=해서 storey가되게
 * 
 * 10^0~에서 부터 10^n 하나씩 늘려가며
 * 
 * 자릿수가 0~4일때 -> 내림
 * 5일때 다음 자릿수 5>= -> 올림
 * 	else -> 내림
 * else 올림
 * */
public class Solution_148653 {
	
	  public int solution(int storey) {
	        int answer = 0;
	        
	        while (storey>0) {
				int current = storey%10;
				int next = (storey/10)%10;//다음자리 숫자
				
				if (current<=4) {
					answer += current;
				}else if (current>5) {
					answer+=(10-current);
					storey += 10;
				}
				else if (current==5) {
					if (next>=5) {
						answer+=(10-current);
						storey += 10;
					}
					else {
						answer += current;
					}
				}
				storey /= 10;//다음 자릿수
			}
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution_148653 sol = new Solution_148653();
		
		System.out.println(sol.solution(16));  
		System.out.println(sol.solution(2554)); 

	}

}
