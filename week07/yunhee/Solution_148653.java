package com.Algo.week07;

class Solution_148653 {

    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;

            // 현재 자릿수가 5보다 작으면 내림
            if (digit < 5) {
                answer += digit;
                storey /= 10;
            }

            // 현재 자릿수가 5보다 크면 올림
            else if (digit > 5) {
                answer += (10 - digit);
                storey = storey / 10 + 1;
            }

            // 현재 자릿수가 딱 5인 경우 
            else {
                int nextDigit = (storey / 10) % 10;

                // 다음 자릿수가 5 이상이면 올림
                if (nextDigit >= 5) {
                    answer += 5;
                    storey = storey / 10 + 1;
                }

                // 다음 자릿수가 5 미만이면 내림
                else {
                    answer += 5;
                    storey /= 10;
                }
            }
        }
        return answer;
    }
}