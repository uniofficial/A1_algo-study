import java.util.Arrays;

public class Solution_43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[0] * n;

        while(left <= right){
            long mid = left + (right - left) / 2;
            long sum = 0;

            for(int time : times){
                sum += mid / time;
            }

            if(sum >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution_43238 s = new Solution_43238();
        System.out.println(s.solution(6, new int[]{7,10}));
    }
}
