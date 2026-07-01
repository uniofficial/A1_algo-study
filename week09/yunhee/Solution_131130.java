// 혼자 놀기의 달인 

package com.Algo.week09;

import java.util.*;

class Solution_131130 {
    public int solution(int[] cards) {

        boolean[] visited = new boolean[cards.length];
        List<Integer> groups = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {

            // 이미 열린 상자라면 건너뜀
            if (visited[i]) continue;

            int count = 0;
            int current = i;

            // 아직 열지 않은 상자 계속 따라감 
            // cards[current]는 다음에 열 상자 번호
            while (!visited[current]) {
                visited[current] = true;
                count++;

                current = cards[current] - 1;
            }

            // 하나의 상자 그룹 크기 저장
            groups.add(count);
        }

        // 그룹이 하나뿐이면 두 번째 그룹을 만들 수 없으므로 0점
        if (groups.size() < 2) {
            return 0;
        }

        // 가장 큰 두 그룹을 찾기 위해 내림차순 정렬
        groups.sort(Collections.reverseOrder());

        return groups.get(0) * groups.get(1);
    }
}