// 타겟 넘버 

package com.Algo.week05;

class Solution_43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int idx, int sum) {

        // 모든 숫자 다 씀 
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 현재 숫자 더하는 경우
        dfs(numbers, target, idx + 1, sum + numbers[idx]);

        // 현재 숫자 빼는 경우
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}