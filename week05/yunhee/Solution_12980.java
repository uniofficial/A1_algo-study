// 점프와 순간이동 

package com.Algo.week05;

class Solution_12980 {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {

            // 마지막 비트가 1이면 배터리 사용
            if ((n & 1) == 1) {
                answer++;
            }
            // 오른쪽으로 1비트 이동 (= 2로 나누기)
            n >>= 1;
        }

        return answer;
    }
}