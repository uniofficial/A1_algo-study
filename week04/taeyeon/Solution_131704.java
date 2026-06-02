import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int in = 1;
        Deque<Integer> stack = new LinkedList<>();

        for (int out : order) {
            if (in > out) {
                if (!stack.isEmpty() && stack.peekLast() == out) {
                    stack.pollLast();
                    answer++;
                    continue;
                }
                return answer;
            }

            while (in < out) {
                stack.offerLast(in++);
            }

            in++;
            answer++;
        }

        return answer;
    }
}