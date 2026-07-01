// 카운트다운 

package com.Algo.week09;

import java.util.*;

class Solution_131129 {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];

        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        // 한 번 던져서 얻을 수 있는 점수와 싱글/불 여부 저장
        List<int[]> scores = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            scores.add(new int[]{i, 1}); // 싱글
            scores.add(new int[]{i * 2, 0}); // 더블
            scores.add(new int[]{i * 3, 0}); // 트리플
        }

        scores.add(new int[]{50, 1}); // 불

        for (int i = 1; i <= target; i++) {
            for (int[] score : scores) {
                int point = score[0];
                int singleOrBull = score[1];

                if (i - point < 0) continue;
                if (dp[i - point][0] == Integer.MAX_VALUE) continue;

                int dartCount = dp[i - point][0] + 1;
                int singleBullCount = dp[i - point][1] + singleOrBull;

                // 1순위 -> 다트 수 적은 경우
                if (dp[i][0] > dartCount) {
                    dp[i][0] = dartCount;
                    dp[i][1] = singleBullCount;
                }

                // 2순위 -> 다트 수 같다면 싱글/불 횟수가 많은 경우
                else if (dp[i][0] == dartCount && dp[i][1] < singleBullCount) {
                    dp[i][1] = singleBullCount;
                }
            }
        }

        return dp[target];
    }
}