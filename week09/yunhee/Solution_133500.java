// 등대 

package com.Algo.week09;

import java.util.*;

class Solution_133500 {
    public int solution(int n, int[][] lighthouse) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : lighthouse) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        // dp[node][0] : node 등대를 끄는 경우 해당 서브트리에서 필요한 최소 등대 수
        // dp[node][1] : node 등대를 켜는 경우 해당 서브트리에서 필요한 최소 등대 수
        int[][] dp = new int[n + 1][2];

        boolean[] visited = new boolean[n + 1];

        // 재귀 DFS 대신 스택 사용
        // n이 클 경우 재귀는 StackOverflow가 날 수 있어서 반복문으로 처리
        Stack<int[]> stack = new Stack<>();

        // {현재 노드, 부모 노드, 방문 상태}
        // state = 0 : 처음 방문
        // state = 1 : 자식 처리 후 다시 방문
        stack.push(new int[]{1, 0, 0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            int node = current[0];
            int parent = current[1];
            int state = current[2];

            if (state == 0) {
                // 나중에 자식들 모두 처리한 뒤 다시 계산하기 위해 넣음 
                stack.push(new int[]{node, parent, 1});

                for (int next : graph[node]) {
                    if (next == parent) continue;

                    stack.push(new int[]{next, node, 0});
                }
            } else {
                // 현재 등대를 켜는 경우 (자기 자신 등대 1개 카운트하고 시작) 
                dp[node][1] = 1;

                for (int next : graph[node]) {
                    if (next == parent) continue;

                    // 현재 node를 끄면, node와 연결된 자식 next는 반드시 켜져야 함
                    dp[node][0] += dp[next][1];

                    // 현재 node를 켜면, 자식 next는 켜도 되고 꺼도 됨
                    // 둘 중 더 작은 값 선택
                    dp[node][1] += Math.min(dp[next][0], dp[next][1]);
                }
            }
        }

        // 1번 등대를 켜는 경우와 끄는 경우 중 최소값
        return Math.min(dp[1][0], dp[1][1]);
    }
}