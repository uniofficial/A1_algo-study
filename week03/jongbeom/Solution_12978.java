package com.algo;

import java.util.*;

public class Solution_12978 {

	class Solution {
		static int N;
		static int INF = 1_000_000_000;
		static int[] dist;
		static ArrayList<Node>[] list;
		
		static class Node {
		    int v, w;
		    Node(int v, int w){
		        this.v = v;
		        this.w = w;
		    }
		}
		
		static void dijkstra(int st) {
			
			dist = new int[N+1];
			boolean[] visit = new boolean[N+1];
			
			
			
			Arrays.fill(dist,  INF);
			dist[st] = 0;
			
			
			
			for(int i=0; i<N-1; i++) {
				int minIdx = -1;
				int min = INF;
				
				for(int j=1; j<=N; j++) {
					if(!visit[j] && min > dist[j]) {
						min = dist[j];
						minIdx =j;
					}
				}
				
				if(minIdx == -1) {
					break;
				}
				visit[minIdx] = true;
				
				for(Node cur : list[minIdx]) {
					if(!visit[cur.v] && dist[cur.v] > dist[minIdx] + cur.w) {
						dist[cur.v] = dist[minIdx] + cur.w;
					}
				}
			}
		}
	    public int solution(int N, int[][] road, int K) {
	    	this.N=N;
	    	list = new ArrayList[N+1];
	    	
	    	for(int i=1; i<=N; i++) {
	    		list[i] = new ArrayList<>();
	    	}
	    	
	    	
	        for(int i=0; i<road.length; i++) {
	        	int a = road[i][0];
	        	int b = road[i][1];
	        	int c = road[i][2];
	        	
	        	list[a].add(new Node(b, c));
	        	list[b].add(new Node(a, c));
	        }
	        
	        dijkstra(1);
	        
	        int answer =0;
	        for(int i=1; i<=N; i++) {
	        	if(dist[i] <= K) answer++;
	        	
	        }
	        
	        
	        
	        
	        

	        return answer;
	    }
	}
}
