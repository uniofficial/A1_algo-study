// 실패율 

package com.Algo.week03;
import java.util.*;

public class Solution_42889 {
	    static class Stage {
	        int stageNum;
	        double failRate;
	        
	        public Stage(int stageNum, double failRate) {
	            this.stageNum = stageNum;
	            this.failRate = failRate;
	        }
	    }
	    
	    public int[] solution(int N, int[] stages) {
	        
	        // 각 스테이지에 머물러 있는 사람 수 저장
	        int[] count = new int[N + 2];
	       
	        // stages 배열 순회하면서 현 스테이지 인원 카운트
	        for (int s : stages) {
	            count[s]++;
	        }
	        
	        List<Stage> list = new ArrayList<>();
	        
	        // 현 스테이지 도달한 전체 유저 수
	        int players = stages.length;
	        
	        // 1~N번 스테이지 실패율 계산
	        for (int i = 1; i <= N; i++) {
	            
	            double failRate = 0;
	            
	            // 도달한 유저 o -> 실패율 계산
	            if (players != 0) {
	                failRate = (double) count[i] / players;
	            }
	            
	            // 스테이지 번호, 실패율 저장
	            list.add(new Stage(i, failRate));

	            // 현재 스테이지에서 실패한 사람 수 제거 (담 스테이지 계산 위함) 
	            players -= count[i];
	        }
	        
	        // 실패율 기준 내림차순 정렬
	        // 실패율 같으면 스테이지 번호 오름차순
	        Collections.sort(list, (a, b) -> {
	            
	            // 실패율 같으면 번호 작은 것 우선
	            if (a.failRate == b.failRate) {
	                return a.stageNum - b.stageNum;
	            }
	            
	            // 실패율 높은 순 정렬
	            return Double.compare(b.failRate, a.failRate);
	        });
	        
	        int[] answer = new int[N];
	        
	        for (int i = 0; i < N; i++) {
	            answer[i] = list.get(i).stageNum;
	        }
	        
	        return answer;
	    }
	}