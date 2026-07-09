import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> list = new PriorityQueue<>();

        for(int i : scoville){
            list.add(i);
        }
        int cnt = 0;
        while(list.size() >= 2 && list.peek() < K){
            int val1 = list.poll();
            int val2 = list.poll();
            int val3 = val1 + val2 * 2;
            list.offer(val3);

            cnt++;
        }

        if(list.peek() < K) return -1;

        return cnt;
    }
}