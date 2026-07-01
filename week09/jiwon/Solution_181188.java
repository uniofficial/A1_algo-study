package com.AlgoStudy.A1;

import java.util.Arrays;

/*
 * 겹치는 구간에 발사
 * 최대한 많이 겹치게
 * Greedy
 * 끝나는 시점 으로 정렬
 * */
public class Solution_181188 {
	public int solution(int[][] targets) {
		
		Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
		int answer = 0;
		
		double x=-1;
		for (int[] is : targets) {
			int s=is[0];
			int e=is[1];
			//미사일이 기존거 보다 뒤에서 쐈을때
			if (s>=x) {
				answer++;
				x=e;
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_181188 sol = new Solution_181188();
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.println(sol.solution(targets));

	}

}
