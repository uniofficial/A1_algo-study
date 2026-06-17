package com.Algo.week07;

/*
 * x좌표와 y좌표가 모두 k의 배수인 점들만 찍음
 * (x, y) = (a*k, b*k), a,b >= 0
 * 원점(0,0)으로부터의 거리가 d 이하인 점만 인정 
 * 조건을 만족하는 점의 개수는? 
 *
 * 원의 방정식: x² + y² <= d²
*/

class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (long x = 0; x <= d; x += k) {
            long maxY = (long) Math.sqrt((long) d * d - x * x);

            answer += (maxY / k) + 1;
        }
        return answer;
    }
}