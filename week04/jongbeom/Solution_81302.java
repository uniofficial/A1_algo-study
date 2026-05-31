package com.algo;

public class Solution_81302 {
	
	class Solution {
		static int[] dr = {-1,1,0,0};
		static int[] dc = {0,0,-1,1};
		
		static int[] ddr = {-1,-1,1,1};
		static int[] ddc = {-1,1,-1,1};
		
	    public int[] solution(String[][] places) {
	        int[] answer = new int[5];
	        
	        for(int i=0; i<5; i++) {
	        	boolean ok = true;
	        	
	        	for(int r = 0; r<5 && ok; r++) {
	        		for(int c = 0; c<5 && ok; c++) {
	        			if(places[i][r].charAt(c)== 'P') {
	        				if(!check(r, c, places[i])) {
	        					ok = false;
	        				}
	        			}
	        		}
	        	}
	        	answer[i] = ok ? 1 : 0;
	        }
	        return answer;
	    }
	    
	    private boolean check(int r, int c, String[] place) {
	    	//1.상하좌우 거리 1검사
	    	for(int d =0; d< 4; d++) {
	    		int nr = r+ dr[d];
	    		int nc = c + dc[d];
	    		
	    		if(!isValid(nr, nc)) continue;
	    		
	    		if(place[nr].charAt(nc) == 'P') {
	    			return false;
	    		}
	    	}
	    	//2.상하좌우 거리 2 검사
	    	for(int d =0; d< 4; d++) {
	    		int nr = r+ dr[d] * 2;
	    		int nc = c + dc[d] * 2;
	    		
	    		if(!isValid(nr, nc)) continue;
	    		
	    		//중간 칸에 0인지 판단하기 위
	    		int mr = r + dr[d];
	    		int mc = c + dc[d];
	    		
	    		if(place[nr].charAt(nc) == 'P'
	    					&& place[mr].charAt(mc) == 'O') {
	    			return false;
	    		}
	    	}
	    	
	    	//3.대각선 검사
	    	for(int d =0; d< 4; d++) {
	    		int nr = r+ ddr[d];
	    		int nc = c + ddc[d];
	    		
	    		if(!isValid(nr, nc)) continue;
	    		
	    		if(place[nr].charAt(nc) == 'P') {
	    			if(place[r].charAt(nc) == 'O'
	    				||	 place[nr].charAt(c) == 'O') {
	    			return false;
	    		   }
	    		}

            }
	    	return true;
        }
	    private boolean isValid(int r, int c) {

	        return r >= 0 && c >= 0 && r < 5 && c < 5;

	    }

        

    }

    

}
