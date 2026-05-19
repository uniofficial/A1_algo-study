// 배달

package com.Algo.week03;

import java.util.*;

class Solution_12978 {

 static class Node {
     int village; // 도착 마을 번호
     int time;    // 걸리는 시간

     Node(int village, int time) {
         this.village = village;
         this.time = time;
     }
 }

 public int solution(int N, int[][] road, int K) {

     // 그래프  
     List<Node>[] graph = new ArrayList[N + 1];

     // 각 마을마다 연결 리스트  
     for (int i = 1; i <= N; i++) {
         graph[i] = new ArrayList<>();
     }

     // road 정보 그래프에 저장
     // 양방향 도로니까 양쪽 모두 추가
     for (int[] r : road) {
         int from = r[0];
         int to = r[1];
         int cost = r[2];

         graph[from].add(new Node(to, cost));
         graph[to].add(new Node(from, cost));
     }

     // distance[i]는 1번 마을에서 i번 마을까지의 최소 시간
     int[] distance = new int[N + 1];

     // 제일 큰 값으로 초기화
     Arrays.fill(distance, Integer.MAX_VALUE);

     distance[1] = 0;     // 1번 -> 1번 시간은 0 

     // 우선순위 큐
     // 시간이 가장 짧은 마을부터 꺼내기 위해 사용
     PriorityQueue<Node> pq =
             new PriorityQueue<>((a, b) -> a.time - b.time);

     // 시작점 추가
     pq.offer(new Node(1, 0));

     // 다익스트라 시작~ 
     while (!pq.isEmpty()) {

         // 현재 가장 빨리 도착 가능한 마을 꺼냄 
         Node current = pq.poll();

         int currentVillage = current.village;
         int currentTime = current.time;

         // 이미 더 짧은 경로 있으면 컨티뉴 
         if (currentTime > distance[currentVillage]) {
             continue;
         }

         // 현재 마을과 연결된 모든 마을 탐색
         for (Node next : graph[currentVillage]) {
             int nextVillage = next.village;

             // 지금까지 걸린 시간 + 다음 도로 시간
             int newTime = currentTime + next.time;

             // 더 짧은 경로 발견하면 갱신
             if (newTime < distance[nextVillage]) {
                 distance[nextVillage] = newTime;

                 // 큐에 새 경로 추가
                 pq.offer(new Node(nextVillage, newTime));
             }
         }
     }

     // K 시간 이하로 도달 가능한 마을 개수 세기
     int answer = 0;

     for (int i = 1; i <= N; i++) {
         if (distance[i] <= K) {
             answer++;
         }
     }
     return answer;
 }
}