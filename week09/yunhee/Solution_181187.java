// 두 원 사이의 정수 쌍 

package com.Algo.week09;

class Solution_181187 {
    public long solution(int r1, int r2) {

        long answer = 0;
        long r1Square = (long) r1 * r1;
        long r2Square = (long) r2 * r2;

        /*
         * x를 1부터 r2까지 움직이면서 해당 x에서 가능한 y의 개수 구함
         * 원의 공식 : x^2 + y^2 <= r^2
         */
        for (long x = 1; x <= r2; x++) {

            long xSquare = x * x;

            /*
             * 바깥 원 안에 들어오는 y의 최댓값
             * y <= sqrt(r2^2 - x^2)
             */
            long maxY = (long) Math.floor(Math.sqrt(r2Square - xSquare));

            /*
             * 안쪽 원 밖에 있어야 하므로 x^2 + y^2 >= r1^2
             * y >= sqrt(r1^2 - x^2)
             *
             * 단, r1^2 - x^2 <= 0 이면
             * 이미 안쪽 원의 오른쪽 바깥이므로 y는 0부터 ok 
             */
            long minY = 0;

            if (r1Square - xSquare > 0) {
                minY = (long) Math.ceil(Math.sqrt(r1Square - xSquare));
            }

             // 현재 x에서 가능한 y 개수 -> minY ~ maxY까지 포함
            answer += maxY - minY + 1;
        }

        return answer * 4; // 1사분면 기준 계산이므로 *4 
    }
}