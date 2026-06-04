package com.AlgoStudy.A1;

import java.util.*;

/*
 * Hashmap 으로
 * 멈춘곳을 기록
 * 각 스테이지에 몇명 있는지
 * */
public class Solution_42889 {
	
	static class Stage implements Comparable<Stage> {
        int id;
        double rate;

        public Stage(int id, double rate) {
            this.id = id;
            this.rate = rate;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.rate == o.rate) {
                return Integer.compare(this.id, o.id);
            }
            return Double.compare(o.rate, this.rate);
        }
    }
	public int[] solution(int N, int[] stages) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int stage : stages) {
			map.put(stage, map.getOrDefault(stage, 0)+1);
		}
		
		//1~N 실패율 계산
		List<Stage> stageList = new ArrayList<>();
		int totalPlayer = stages.length;
		for (int i = 1; i <= N; i++) {
			int unclearedPlayers = map.getOrDefault(i, 0);
			
			double failrate =0;
			
			if (totalPlayer>0) {
				failrate = (double) unclearedPlayers / totalPlayer;
				totalPlayer -=unclearedPlayers;
			}
			stageList.add(new Stage(i, failrate));
		}
		Collections.sort(stageList);

        // 4.결과를 int[] 배열로 변환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).id;
        }

        return answer;
    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42889 sol = new Solution_42889();
        int[] result = sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        
        // 결과 출력 테스트: [3, 4, 2, 1, 5] 가 나와야 합니다.
        for (int val : result) {
            System.out.print(val + " ");
        }

	}

}
