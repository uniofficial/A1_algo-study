package com.algo;

public class Solution_42860 {
    class Solution {
        public int solution(String name) {
            int answer = 0;

            // 1. 위/아래 이동
            for (int i = 0; i < name.length(); i++) {
                char alpha = name.charAt(i);
                answer += Math.min(alpha - 'A', 'Z' - alpha + 1);
            }

            // 2. 좌/우 이동
            int move = name.length() - 1;
            for (int i = 0; i < name.length(); i++) {
                int next = i + 1;

                while (next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                move = Math.min(
                    move,
                    i + name.length() - next + Math.min(i, name.length() - next)
                );
            }
            return answer + move;
        }
    }
}