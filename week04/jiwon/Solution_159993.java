package com.AlgoStudy.A1;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * 
 * 가장 빠르게 -> BFS
 * 레버를 무조건 열어야한다
 * S->L BFS
 * L->E BFS
 * 
 * */
public class Solution_159993 {
	 static  int[] dx = {-1, 1, 0, 0};
     static  int[] dy = {0, 0, -1, 1};
   
     
     public int bfs(String[] maps, int []start, int target) {
    	 int n = maps.length;
		 int m = maps[0].length();
		 
		 ArrayDeque<int[]> q = new ArrayDeque<>();
		 int[][] dist = new int[n][m];
		 for (int i = 0; i < n; i++) {
			 Arrays.fill(dist[i], -1);
		 }
		 
		 q.offer(new int[] {start[0], start[1]});
		 
		 dist[start[0]][start[1]] = 0;
		 
		 while (!q.isEmpty()) {
			 int[] cur = q.poll();
			 int cy = cur[0];
			 int cx = cur[1];
			 //최단거리 반환
			 if (maps[cy].charAt(cx) == target) {
	                return dist[cy][cx];
	            }
			 
			 for (int i = 0; i < 4; i++) {
				 int nx = cx + dx[i];
				 int ny = cy + dy[i];
				 
				 if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (maps[ny].charAt(nx) != 'X' && dist[ny][nx] == -1) {
						dist[ny][nx] = dist[cy][cx] + 1;
						q.offer(new int[]{ny, nx});
					}
				}
			}
		}
		 return -1;
	}
     
	 public int solution(String[] maps) {
		 int n = maps.length;
		 int m = maps[0].length();
		 
		 int[] S = new int[2];
	     int[] L = new int[2];
	     int[] E = new int[2];
	     
		 for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char ch = maps[i].charAt(j);
				
				if (ch=='S') {
					S[0] = i; S[1] = j;
				}
				else if (ch=='L') {
					L[0] = i; L[1] = j;
				}
				else if (ch=='E') {
					E[0] = i; E[1] = j;
				}
				
			}
		}
		 int toL = bfs(maps, S, 'L');
	      if (toL == -1) return -1;
	      
	      int toE = bfs(maps, L, 'E');
	      if (toE == -1) return -1;
	        
	      return toL + toE;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_159993 sol = new Solution_159993();
        String[][] testMaps = {
            {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"},
            {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}
        };
        
        System.out.println(sol.solution(testMaps[0]));
        System.out.println(sol.solution(testMaps[1])); 

	}

}
