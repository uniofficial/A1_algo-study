package com.AlgoStudy.A1;
/*
 * 초침 분침 시침 동시에 겹치기
 * 초당 이동각도
 * 초침: 360/60= 6도
 * 분침: 360/3600= 0.1도
 * 시침: 360/12/3600도
 * * * 초당 이동각도 정수로
 * 초침: 360/60= 6도*120 = 720
 * 분침: 360/3600= 0.1도 *120 = 12
 * 시침: 360/12/3600도*120 =1
 * * 후 한바퀴 360*120 바퀴를 기준으로 계산
 * % 43200
 * * 현재 초침각도<현재 분침 각도 and 다음 초침 각도 >= 다음 분침 각도
 * or
 * 현재 초침각도<현재 시침 각도 and 다음 초침 각도 >= 다음 시침 각도
 * * 일때 answer++
 * * */
public class Solution_250135 {
	  public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
	        int answer = 0;
	        
	        int startTime = h1 * 3600 + m1 * 60 + s1;
	        int endTime = h2 * 3600 + m2 * 60 + s2;
	        
	        // [수정 1] 시작 시점에 이미 딱 겹쳐서 출발하는 경우 예외 처리
	        if ((startTime * 720) % 43200 == (startTime * 12) % 43200 || 
	            (startTime * 720) % 43200 == (startTime * 1) % 43200) {
	            answer++;
	        }
	        
	        for (int t = startTime; t < endTime; t++) {
	        	int curSecAngle  = (t * 720);
	        	int curMinAngle  = (t * 12);
	        	int curHourAngle = (t * 1);
	        	
	        	int nextSecAngle  = ((t+1) * 720);
	        	int nextMinAngle  = ((t+1) * 12);
	        	int nextHourAngle = ((t+1) * 1);
	        	
	        	int cSec = curSecAngle % 43200;
	        	int cMin = curMinAngle % 43200;
	        	int cHour = curHourAngle % 43200;
	        	
	        	int nSec = nextSecAngle % 43200;
	        	int nMin = nextMinAngle % 43200;
	        	int nHour = nextHourAngle % 43200;
	        	
	        	// [수정 2] 다음 시점의 각도가 현재보다 작아졌다면(0도로 리셋되었다면)
	        	// 연속적인 대소 비교를 위해 원래 누적되어야 할 43200을 더해줍니다.
	        	if (nSec < cSec) nSec += 43200;
	        	if (nMin < cMin) nMin += 43200;
	        	if (nHour < cHour) nHour += 43200;
	        	
	        	boolean hourMatch = false;
	            boolean minMatch = false;
	        	
	        	if (cSec < cMin && nSec >= nMin) {
	        		minMatch=true;
				}
	        	if (cSec < cHour && nSec >= nHour) {
	        		hourMatch=true;
				}
	        	if (minMatch && hourMatch) {
	        		// 시침과 분침을 동시에 추월하는 순간 (예: 정확히 12시 정각으로 수렴할 때)
	        		if (nMin == nHour) {
	        			answer += 1;
	        		} else {
	        			answer += 2;
	        		}
	        	} else if (minMatch || hourMatch) {
	        		answer += 1;
	        	}
	        }
	        
	        return answer;
	        }
	        
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_250135 solver = new Solution_250135();
        System.out.println(solver.solution(0, 5, 30, 0, 7, 0));
	}

}