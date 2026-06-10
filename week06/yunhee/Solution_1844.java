// 게임 맵 최단거리

package com.Algo.week06;

import java.util.*;

class Solution_1844 {

    public int solution(int[][] maps) {
        int n = maps[0].length;
        int m = maps.length;
 
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true; // 시작점 방문 처리

        Queue<Node> nodes = new LinkedList<>();

        // 시작 위치 (0,0), 이동 거리 1
        Node startNode = new Node(0, 0, 1);

        nodes.offer(startNode);

        // BFS 시작
        while (!nodes.isEmpty()) {

            // 현재 위치 꺼내기
            Node node = nodes.poll();

            // 목적지 도착
            if (node.x == n - 1 && node.y == m - 1) {
                return node.cost;
            }

            // 상하좌우 탐색
            for (int c = -1; c <= 1; c += 1) {
                for (int r = -1; r <= 1; r += 1) {

                    // 대각선 이동 제거
                    if (c * r != 0)
                        continue;

                    // 다음 위치 계산
                    int col = node.x + c;
                    int row = node.y + r;

                    // 이동 가능하면
                    if (
                        // 맵 범위 안인지 
                        0 <= col && col < n &&
                        0 <= row && row < m &&

                        // 벽이 아닌지 
                        maps[row][col] == 1 &&

                        // 아직 방문하지 않았는지 체크 
                        !visited[row][col]
                    ) {

                        // 방문 처리
                        visited[row][col] = true;

                        // 거리 +1 후 큐에 저장
                        nodes.offer(
                            new Node(
                                col,
                                row,
                                node.cost + 1
                            )
                        );
                    }
                }
            }
        }

        return -1;  // 도달 못함 
    }

    class Node {

        int x;    
        int y;    
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}