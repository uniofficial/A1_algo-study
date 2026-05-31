package com.AlgoStudy.A1;

import java.util.*;

/* lost와 reserve에 모두 포함 이면 미리 제거
 * 체육복이 없으면 앞번호를 확인
 * 양옆에 체육복이 없으면 실패 
 * 
 * 
 * */
public class Solution_42862 {
	public int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
        Arrays.sort(reserve);

        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        // 우선 여벌이 있는 학생들을 set에 다 넣기
        for (int re : reserve) {
            reserveSet.add(re);
        }

        for (int los : lost) {
            if (reserveSet.contains(los)) {
                
                reserveSet.remove(los); 
                
            } else {
                lostSet.add(los);
            }
        }

        int answer = n - lostSet.size();

        
        for (int los : lost) {
            
            if (!lostSet.contains(los)) continue;

           
            if (reserveSet.contains(los - 1)) {
                reserveSet.remove(los - 1);
                answer++; 
            }
            
            else if (reserveSet.contains(los + 1)) {
                reserveSet.remove(los + 1);
                answer++; 
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42862 sol = new Solution_42862();
		
        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 5
        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{3}));       // 4
        System.out.println(sol.solution(3, new int[]{3}, new int[]{1}));          // 2

	}

}
