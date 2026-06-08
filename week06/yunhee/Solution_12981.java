// 영어 끝말잇기 

package com.Algo.week06;

import java.util.*;

class Solution_12981 {
    public int[] solution(int n, String[] words) {

        Set<String> used = new HashSet<>();

        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            // 중복 단어 or 끝말잇기 실패
            if (used.contains(curr) || prev.charAt(prev.length() - 1) != curr.charAt(0)) {
                int player = i % n + 1;
                int turn = i / n + 1;

                return new int[]{player, turn};
            }
            used.add(curr);
        }
        return new int[]{0, 0};
    }
}