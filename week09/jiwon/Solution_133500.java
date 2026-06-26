package com.AlgoStudy.A1;

import java.util.ArrayList;

/*
 * 
 * 몇개가 이어져 있는지
 * 1개만 이어져있다
 * 이어져 있는거 무조건 킨다
 * DFS
 * 자식 노드 1이면 나는 true 내 부보는 안킴
 * 
 * */
public class Solution_133500 {
	
	static ArrayList<Integer>[] graph;
    static int answer;
    
	public static boolean dfs(int current, int parent) {
		
		boolean needToTurnOnMe = false;
		
		for (int next  : graph[current]) {
			if (next == parent) continue;
			
			if (dfs(next, current)) {//자식이 꺼졌을 때
				needToTurnOnMe = true;
			}
			
		}
		if (needToTurnOnMe) {//자식이 1일때
			answer++; //나는 켜지고
			return false; //부모는 켜지지 않는다
		}
		
		return true;
	}

	 public int solution(int n, int[][] lighthouse) {
	        graph = new ArrayList[n + 1];
	        
	        for (int i = 1; i <= n; i++) {
	            graph[i] = new ArrayList<>();
	        }
	        
	        for (int[] edge : lighthouse) {
	        	int u = edge[0];
	            int v = edge[1];
	            graph[u].add(v);
	            graph[v].add(u);
			}
	        
	        dfs(1, 0);
	        
	        return answer;
	        
	        
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_133500 solver = new Solution_133500();
		int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        
        System.out.println(solver.solution(n, lighthouse)); 

	}

}
