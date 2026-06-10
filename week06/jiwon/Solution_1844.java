package com.AlgoStudy.A1;

import java.util.*;

/*
 * BFS
 * */
public class Solution_1844 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	
	
	 public int solution(int[][] maps) {
		 int Y = maps.length;
	     int X = maps[0].length;
	        
	     int[][] dist = new int[Y][X];
	     
	     ArrayDeque<int[]> q = new ArrayDeque<>();
	     
	  // 시작점 (0,0) 설정 - 첫 번째 칸도 카운트에 포함하므로 1로 시작
	        q.offer(new int[]{0, 0});
	        dist[0][0] = 1;
	        
	        while(!q.isEmpty()) {
	            int[] cur = q.poll();
	            int cy = cur[0];
	            int cx = cur[1];
	            
	            // 목적지(우측 하단)에 도착했다면, 그 순간의 거리가 무조건 최단 거리!
	            if (cy == Y - 1 && cx == X - 1) {
	                return dist[cy][cx];
	            }
	            
	            for (int i = 0; i < 4; i++) {
	                int ny = cy + dy[i];
	                int nx = cx + dx[i];
	                
	                // 1. 맵 범위 안에 있는지 확인
	                if (ny >= 0 && ny < Y && nx >= 0 && nx < X) {
	                    // 2. 갈 수 있는 길(1)이고 아직 방문하지 않은 곳(0)인지 확인
	                    if (maps[ny][nx] == 1 && dist[ny][nx] == 0) {
	                        dist[ny][nx] = dist[cy][cx] + 1;
	                        q.offer(new int[]{ny, nx});
	                    }
	                }
	            }
	        }
	       
	        return -1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_1844 sol = new Solution_1844();

        int[][] maps1 = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };
        System.out.println(sol.solution(maps1));

	}

}
