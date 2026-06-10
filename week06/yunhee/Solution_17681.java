// 귤 고르기 

// 크기별 개수 세고 개수 많은 종류부터 선택. (그리디) 

package com.Algo.week06;

import java.util.*;

class Solution_17681 {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        // 귤 크기별 개수 세기
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder()); // 개수 내림차순 정렬

        int answer = 0;
        int picked = 0;

        // 많이 있는 종류부터 픽 
        for (int count : counts) {
            picked += count;
            answer++;

            if (picked >= k) {
                break;
            }
        }

        return answer;
    }
}