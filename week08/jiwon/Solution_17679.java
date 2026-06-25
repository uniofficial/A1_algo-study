package com.AlgoStudy.A1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_17679 {
    /*
     * 2*2 형태
     * 2차원 배열
     * * 2*2 구역에서 전부 같은지 완탐 
     * 중력 -> 스택 대신 deque pop
     * 안터진 것들을 deque의 뒤쪽에서 부터 넣는다
     * 한번에 pop
     * */
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 2차원 배열 조작을 위해 char[][] map 선언 및 초기화
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        // 블록이 더 이상 안 터질 때까지 매 턴 반복 (시뮬레이션 루프)
        while (true) {
            boolean[][] isTarget = new boolean[m][n];
            boolean hasRemoved = false;

            /*
             * 1. 2*2 구역에서 전부 같은지 완탐
             */
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '.') continue; // 이미 터진 공백은 패스
                    
                    char cur = map[i][j];
                    // 오른쪽, 아래, 대각선 아래 비교
                    if (map[i][j+1] == cur && map[i+1][j] == cur && map[i+1][j+1] == cur) {
                        isTarget[i][j] = true;
                        isTarget[i][j+1] = true;
                        isTarget[i+1][j] = true;
                        isTarget[i+1][j+1] = true;
                        hasRemoved = true;
                    }
                }
            }

            // 더 이상 터질 블록이 없다면 반복 종료
            if (!hasRemoved) break;

            /*
             * 2. 한번에 pop (마킹된 블록 공백 처리 및 카운트)
             */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isTarget[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            /*
             * 3. 중력 -> 스택 대신 deque pop
             */
            for (int j = 0; j < n; j++) {
                Deque<Character> deque = new ArrayDeque<>();
                
                // 안터진 것들을 deque의 뒤쪽에서 부터 넣는다 (위 -> 아래 순회)
                for (int i = 0; i < m; i++) {
                    if (map[i][j] != '.') {
                        deque.addLast(map[i][j]);
                    }
                }
                
                // 아래쪽 행(m-1)부터 위쪽 방향으로 데크에서 꺼내서 채우기
                for (int i = m - 1; i >= 0; i--) {
                    if (!deque.isEmpty()) {
                        // 뒤에서부터 넣었으므로, 가장 아래쪽 블록을 꺼내기 위해 pollLast()
                        map[i][j] = deque.pollLast(); 
                    } else {
                        map[i][j] = '.'; // 남은 위쪽 공간은 공백 처리
                    }
                }
            }
        } 

        return answer;
    }

    public static void main(String[] args) {
        Solution_17679 solver = new Solution_17679();
        
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        
        System.out.println(solver.solution(m, n, board)); 
    }
}