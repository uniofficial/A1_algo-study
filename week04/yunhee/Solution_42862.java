// 체육복 

// 학생별 체육복 개수 배열로
// 체육복 없는 학생 발견 시 앞번호 먼저 확인
// 양옆 다 여벌 없으면 실패 -> 리턴

package com.Algo.week04;

class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] clothes = new int[n + 1];

        // 첨엔 모두 한 개씩 가짐 
        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        // 도난당한 학생  
        for (int student : lost) {
            clothes[student]--;
        }

        // 여벌 있는 학생 
        for (int student : reserve) {
            clothes[student]++;
        }

         // 체육복 없는 학생 탐색
         // 앞번호 -> 뒷번호 순으로 빌리기 시도 
        for (int i = 1; i <= n; i++) {

            // 체육복 없는 경우
            if (clothes[i] == 0) {

                // 앞학생 여벌 있으면 
                if (i > 1 && clothes[i - 1] == 2) {
                    clothes[i]++;
                    clothes[i - 1]--;
                }

                // 뒷학생 여벌 있으면 
                else if (i < n && clothes[i + 1] == 2) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        int answer = 0;

        // 체육복 있는 학생 수 카운트 
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}