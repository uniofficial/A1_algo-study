package com.algo;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1844 {
	
	class Solution {
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		public int bfs(int[][] maps) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[maps.length][maps[0].length];
			visited[0][0] = true;
			q.offer(new int[] {0,0});
			
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				
				for(int d = 0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(maps.length<= nx || nx < 0 || maps[0].length <= ny || ny < 0) {
						continue;
					}
					if(maps[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						maps[nx][ny] = maps[x][y] +1;
						q.offer(new int[] {nx,ny});
					}
					
					
				}
				
				
				
			}
			if(maps[maps.length -1][maps[0].length-1] == 1) {
				return -1;
			}else {
				return maps[maps.length -1][maps[0].length-1];
			}
			
			
		}
	    public int solution(int[][] maps) {
	        return bfs(maps);
	    }
	}

}
