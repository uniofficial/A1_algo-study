import java.util.*;

class Solution {
    private int answer = 0;
    private int t;

    public int solution(int[] numbers, int target) {
        answer = 0;
        t = target;

        dfs(0, 0, numbers);
        return answer;
    }

    private void dfs(int idx, int sum, int[] numbers) {
        if (idx == numbers.length) {
            if (t == sum) {
                answer++;
            }
            return;
        }

        dfs(idx + 1, sum + numbers[idx], numbers);
        dfs(idx + 1, sum - numbers[idx], numbers);
    }
}