import java.util.*;

class Solution {

    public long solution(int k, int d) {
        long answer = 0;
        long dist = (long)Math.pow(d, 2);

        for(long i = 0 ; i <= d ; i += k){
            long x = (long)Math.pow(i, 2);
            long y = (long)Math.sqrt(dist - x);
            answer += y/k + 1;
        }


        return answer;
    }
}
