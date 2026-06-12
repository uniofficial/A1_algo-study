package com.Algo.week07;

import java.util.Arrays;

class Solution_43238 {
    public long solution(int n, int[] times) {

        // left는 최소 가능 시간 (1분)
        // right는 가장 빠른 심사관이 n명 전부 처리하는 최악의 시간
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[0] * n;

        // 이진 탐색 시작
        while (left < right) {
            long mid = (left + right) / 2;

            // mid분 동안 처리 가능한 총 인원 계산
            long count = 0;
            for (int time : times) {
                count += mid / time;

                if (count >= n) break; // 조기 종료
            }

            // 판별 결과에 따라 탐색 범위 조정
            if (count >= n) {
                // mid분으로 가능 -> 더 줄여볼 수 있음
                right = mid;
            } else {
                // mid분으로 불가능 -> 시간을 늘려야 함
                left = mid + 1;
            }
        }
        return left;
    }
}