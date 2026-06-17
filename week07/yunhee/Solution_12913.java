package com.Algo.week07;

/*
 * dp[i][j]는 i행 j열을 밟았을 때 얻을 수 있는 최대 점수
 * 점화식: dp[i][0] = land[i][0] + max(dp[i-1][1], dp[i-1][2], dp[i-1][3])
*/

class Solution_12913 {

    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        // 첫 번째 행 초기화
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        // DP 진행
        for (int i = 1; i < n; i++) {

            dp[i][0] = land[i][0]
                    + Math.max(dp[i - 1][1],
                      Math.max(dp[i - 1][2], dp[i - 1][3]));

            dp[i][1] = land[i][1]
                    + Math.max(dp[i - 1][0],
                      Math.max(dp[i - 1][2], dp[i - 1][3]));

            dp[i][2] = land[i][2]
                    + Math.max(dp[i - 1][0],
                      Math.max(dp[i - 1][1], dp[i - 1][3]));

            dp[i][3] = land[i][3]
                    + Math.max(dp[i - 1][0],
                      Math.max(dp[i - 1][1], dp[i - 1][2]));
        }
        return Math.max(
                Math.max(dp[n - 1][0], dp[n - 1][1]),
                Math.max(dp[n - 1][2], dp[n - 1][3])
        );
    }
}