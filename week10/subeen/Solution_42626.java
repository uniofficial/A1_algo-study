import java.util.PriorityQueue;

class Solution_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }

        while(pq.peek() < K){
            if(pq.size() < 2)
                return -1;

            int a = pq.poll();
            int b= pq.poll();

            pq.offer(a + b * 2);
            answer++;
        }

        return answer; 
    }

    public static void main(String[] args){
        Solution_42626 s = new Solution_42626();
        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
}