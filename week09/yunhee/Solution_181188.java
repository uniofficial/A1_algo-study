// 요격 시스템 

package com.Algo.week09;

import java.util.Arrays;

class Solution_181188 {
    public int solution(int[][] targets) {

        // 폭격 미사일을 끝나는 지점 e 기준으로 오름차순 정렬
    	// 빨리 끝나는 미사일부터 처리해야 함 
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int last = -1;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= last) {
                answer++;

                last = end;
            }
        }

        return answer;
    }
}