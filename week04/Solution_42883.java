import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> Q = new ArrayDeque<>();

        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!Q.isEmpty() && count < k && Q.peekLast() < c) {
                Q.pollLast();
                count++;
            }
            Q.offer(c);
        }

        while (count < k) {
            Q.pollLast();
            count++;
        }

        StringBuilder sb = new StringBuilder(Q.size());
        for (char c : Q) sb.append(c);
        return sb.toString();
    }
}