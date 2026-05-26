// 미로 탈출

// 출발 -> 레버 -> 출구 순서 
// 최단거리. 상하좌우 이동. 벽 존재. -> BFS 
// 출발 -> 레버 최단거리 구하고 레버 -> 출구 최단거리 구하기 

package com.Algo.week04;

import java.util.*;

class Solution_159993 {

    // 상하좌우 이동 방향
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int row, col;

    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;

        // 출발(S), 레버(L), 출구(E) 위치 찾기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                char current = maps[i].charAt(j);

                if (current == 'S') {
                    startX = i;
                    startY = j;
                }

                else if (current == 'L') {
                    leverX = i;
                    leverY = j;
                }

                else if (current == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }
        
        // 출발 -> 레버 최단거리
        int toLever = bfs(startX, startY, leverX, leverY, maps);

        // 레버에 도달 불가능
        if (toLever == -1) {
            return -1;
        }

        // 레버 -> 출구 최단거리
        int toExit = bfs(leverX, leverY, exitX, exitY, maps);

        // 출구 도달 불가능
        if (toExit == -1) {
            return -1;
        }

        // 전체 이동 시간
        return toLever + toExit;
    }

    // BFS 함수
    public int bfs(int startX, int startY,
                   int targetX, int targetY,
                   String[] maps) {

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY, 0});

        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 목표 지점 도착
            if (x == targetX && y == targetY) {
                return dist;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 벗어나면 컨티뉴 
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }

                // 이미 방문한 칸이면 컨티뉴 
                if (visited[nx][ny]) {
                    continue;
                }

                // 벽(X)이면 이동 불가
                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                visited[nx][ny] = true;	 // 방문 처리
                queue.offer(new int[]{nx, ny, dist + 1});  // 다음 위치 큐에 저장
            }
        }
        return -1;
    }
}